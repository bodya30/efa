package ua.efa.landscape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.efa.landscape.dao.PlantDao;
import ua.efa.landscape.model.Plant;

import java.util.List;
import java.util.Map;

@Service
public class DefaultPlantService implements PlantService {

    @Autowired
    private PlantDao plantDao;

    @Override
    public Plant getPlantById(int id) {
        return plantDao.getPlantById(id);
    }

    @Override
    public List<Plant> getAllPlantsPaginated(int pageNumber) {
        return plantDao.getAllPlantsPaginated(pageNumber);
    }

    @Override
    public void deletePlantById(int id) {
        plantDao.deletePlantById(id);
    }

    @Override
    public void insertPlant(Plant plant) {
        plantDao.insertPlant(plant);
    }

    @Override
    public void updatePlant(Plant plant) {
        plantDao.updatePlant(plant);
    }

    @Override
    public List<Plant> getPlantsByCriteriasPagineted(Map<String, Object> params, int pageNumber) {
        return plantDao.getPlantsByCriteriasPaginated(params, pageNumber);
    }
}
