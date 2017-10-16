package ua.efa.landscape.service;

import ua.efa.landscape.model.Plant;

import java.util.List;
import java.util.Map;

public interface PlantService {

    Plant getPlantById(int id);

    List<Plant> getAllPlantsPaginated(int pageNumber);

    void deletePlantById(int id);

    void insertPlant(Plant plant);

    void updatePlant(Plant plant);

    List<Plant> getPlantsByCriteriasPagineted(Map<String, Object> params, int pageNumber);
}
