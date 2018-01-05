package ua.efa.landscape.form;

import javax.validation.constraints.Min;

public class PlantForm {

    private String name;
    private String color;

    @Min(value = 0, message = "form.field.price.min.error")
    private Double priceFrom;

    @Min(value = 0, message = "form.field.price.min.error")
    private Double priceTo;

    @Min(value = 0, message = "form.field.height.min.error")
    private Double heightFrom;

    @Min(value = 0, message = "form.field.height.min.error")
    private Double heightTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public Double getHeightFrom() {
        return heightFrom;
    }

    public void setHeightFrom(Double heightFrom) {
        this.heightFrom = heightFrom;
    }

    public Double getHeightTo() {
        return heightTo;
    }

    public void setHeightTo(Double heightTo) {
        this.heightTo = heightTo;
    }
}
