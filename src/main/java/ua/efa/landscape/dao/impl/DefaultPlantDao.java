package ua.efa.landscape.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ua.efa.landscape.dao.PlantDao;
import ua.efa.landscape.data.PlantPageableData;
import ua.efa.landscape.model.Plant;
import ua.efa.landscape.model.Plant_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Transactional
public class DefaultPlantDao implements PlantDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Plant getPlantById(int id) {
        return getCurrentSession().get(Plant.class, id);
    }

    @Override
    public PlantPageableData getAllPlantsPaginated(PlantPageableData pageableData) {
        int pageSize = pageableData.getPageSize();
        Session session = getCurrentSession();
        CriteriaQuery<Plant> criteriaQuery = session.getCriteriaBuilder().createQuery(Plant.class);
        Root<Plant> root = criteriaQuery.from(Plant.class);
        CriteriaQuery<Plant> query = criteriaQuery.select(root);
        List<Plant> plants = session.createQuery(query)
                .setFirstResult(pageableData.getPageNumber() * pageSize)
                .setMaxResults(pageSize)
                .list();
        long pageCount = getTotalPageCount(query);
        populatePageableData(pageableData, plants, pageCount);
        return pageableData;
    }

    private void populatePageableData(PlantPageableData pageableData, List<Plant> plants, long pageCount) {
        pageableData.setPlantsInPage(plants);
        pageableData.setTotalPageCount(pageCount);
    }

    @Override
    public void deletePlantById(int id) {
        // Firstly load plant to invoke cascade deleting
        Session session = getCurrentSession();
        Plant plant = session.load(Plant.class, id);
        session.delete(plant);
    }

    @Override
    public void insertPlant(Plant plant) {
        getCurrentSession().save(plant);
    }

    @Override
    public void updatePlant(Plant plant) {
        getCurrentSession().update(plant);
    }

    @Override
    public PlantPageableData getPlantsByCriteriasPaginated(Map<String, Object> params, PlantPageableData pageableData) {
        int pageSize = pageableData.getPageSize();
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Plant> root = criteria.from(Plant.class);
        List<Predicate> predicates = getPredicates(params, builder, root);
        CriteriaQuery<Plant> query = criteria.select(root).where(predicates.toArray(new Predicate[]{}));
        List<Plant> plants = session.createQuery(query)
                .setFirstResult(pageableData.getPageNumber() * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        long pageCount = getTotalPageCount(query, predicates.toArray(new Predicate[]{}));
        populatePageableData(pageableData, plants, pageCount);
        return pageableData;
    }

    private long getTotalPageCount(CriteriaQuery query, Predicate ... predicates){
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        countQuery.select(builder.count(query.from(Plant.class)));
        if (predicates.length > 0){
            countQuery.where(predicates);
        }
        return session.createQuery(countQuery).getSingleResult();
    }

    private List<Predicate> getPredicates(Map<String, Object> params, CriteriaBuilder builder, Root<Plant> root) {
        List<Predicate> predicates = new ArrayList<>();

        Optional.ofNullable(equalPredicate(builder, params.get("name"), root.get(Plant_.name))).ifPresent(predicates::add);
        Optional.ofNullable(equalPredicate(builder, params.get("color"), root.get(Plant_.color))).ifPresent(predicates::add);
        Optional.ofNullable(betweenPredicate(builder, root.get(Plant_.height), (Double) params.get("heightFrom"), (Double) params.get("heightTo"))).ifPresent(predicates::add);
        Optional.ofNullable(betweenPredicate(builder, root.get(Plant_.price), (Double) params.get("priceFrom"), (Double) params.get("priceTo"))).ifPresent(predicates::add);

        return predicates;
    }

    private Predicate equalPredicate(CriteriaBuilder builder, Object param, Path path) {
        Predicate predicate = null;
        if (param != null) {
            predicate = builder.equal(path, param);
        }
        return predicate;
    }

    private Predicate betweenPredicate(CriteriaBuilder builder, Path<Double> path, Double from, Double to) {
        Predicate predicate = null;
        if (from != null && to != null) {
            predicate = builder.between(path, from, to);
        } else if (from != null && to == null) {
            predicate = builder.ge(path, from);
        } else if (from == null && to != null) {
            predicate = builder.le(path, to);
        }
        return predicate;
    }
}
