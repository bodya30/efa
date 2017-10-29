package ua.efa.landscape.service;

import ua.efa.landscape.data.PlantPageableData;
import ua.efa.landscape.model.Plant;

import java.util.List;
import java.util.Map;

public interface PlantService {

    Plant getPlantById(int id);

    PlantPageableData getAllPlantsPaginated(PlantPageableData pageableData);

    void deletePlantById(int id);

    void insertPlant(Plant plant);

    void updatePlant(Plant plant);

    PlantPageableData getPlantsByCriteriasPagineted(Map<String, Object> params, PlantPageableData pageableData);
}
