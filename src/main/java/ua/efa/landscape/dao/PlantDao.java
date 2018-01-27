package ua.efa.landscape.dao;

import ua.efa.landscape.data.PlantPageableData;
import ua.efa.landscape.model.Plant;

import java.util.List;
import java.util.Map;

public interface PlantDao {

    Plant getPlantById(int id);

    PlantPageableData getAllPlantsPaginated(PlantPageableData pageableData);

    void deletePlantById(int id);

    void deleteAllPlants();

    void insertPlant(Plant plant);

    void updatePlant(Plant plant);

    PlantPageableData getPlantsByCriteriasPaginated(Map<String, Object> params, PlantPageableData pageableData);
}
