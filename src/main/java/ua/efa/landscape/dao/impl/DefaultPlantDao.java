package ua.efa.landscape.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ua.efa.landscape.dao.PlantDao;
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

    @Value("${db.pagination.size}")
    private int pageSize;

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
    public List<Plant> getAllPlantsPaginated(int pageNumber) {
        Session session = getCurrentSession();
        CriteriaQuery<Plant> criteriaQuery = session.getCriteriaBuilder().createQuery(Plant.class);
        Root<Plant> root = criteriaQuery.from(Plant.class);
        CriteriaQuery<Plant> query = criteriaQuery.select(root);
        return session.createQuery(query)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .list();
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
    public List<Plant> getPlantsByCriteriasPaginated(Map<String, Object> params, int pageNumber) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Plant> root = criteria.from(Plant.class);
        List<Predicate> predicates = getPredicates(params, builder, root);
        CriteriaQuery<Plant> query = criteria.select(root).where(predicates.toArray(new Predicate[]{}));
        return session.createQuery(query)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    private List<Predicate> getPredicates(Map<String, Object> params, CriteriaBuilder builder, Root<Plant> root) {
        List<Predicate> predicates = new ArrayList<>();

        Optional.ofNullable(equalPredicate(builder, (String) params.get("name"), root.get(Plant_.name))).ifPresent(predicates::add);
        Optional.ofNullable(equalPredicate(builder, (String) params.get("color"), root.get(Plant_.color))).ifPresent(predicates::add);
        Optional.ofNullable(betweenPredicate(builder, root.get(Plant_.height), (Double) params.get("heightFrom"), (Double) params.get("heightTo"))).ifPresent(predicates::add);
        Optional.ofNullable(betweenPredicate(builder, root.get(Plant_.price), (Double) params.get("priceFrom"), (Double) params.get("priceTo"))).ifPresent(predicates::add);

        return predicates;
    }

    private Predicate equalPredicate(CriteriaBuilder builder, String param, Path<String> path) {
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
