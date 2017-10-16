package ua.efa.landscape.dao;

import ua.efa.landscape.model.Plant;

import java.util.List;
import java.util.Map;

public interface PlantDao {

    Plant getPlantById(int id);

    List<Plant> getAllPlantsPaginated(int pageNumber);

    void deletePlantById(int id);

    void insertPlant(Plant plant);

    void updatePlant(Plant plant);

    List<Plant> getPlantsByCriteriasPaginated(Map<String, Object> params, int pageNumber);
}
