package ua.efa.landscape.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.efa.landscape.dao.PlantDao;
import ua.efa.landscape.data.PlantPageableData;
import ua.efa.landscape.model.Plant;
import ua.efa.landscape.service.PlantService;

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
    public PlantPageableData getAllPlantsPaginated(PlantPageableData pageableData) {
        return plantDao.getAllPlantsPaginated(pageableData);
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
    public PlantPageableData getPlantsByCriteriasPagineted(Map<String, Object> params, PlantPageableData pageableData) {
        return plantDao.getPlantsByCriteriasPaginated(params, pageableData);
    }
}
