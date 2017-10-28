package ua.efa.landscape.validation;

import ua.efa.landscape.model.Plant;

import java.util.List;
import java.util.Map;

public class PlantFormValidationRespponse {
    private Map<String, String> errors;
    private List<Plant> plants;

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
