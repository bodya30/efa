package ua.efa.landscape.validation;

import java.util.Map;

public class PlantFormValidationRespponse {
    private Map<String, String> errors;

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

}
