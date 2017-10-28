package ua.efa.landscape.form;

import javax.validation.constraints.Min;

public class PlantForm {

    private String name;
    private String color;

    @Min(value = 0, message = "price.min.error")
    private double priceFrom;

    @Min(value = 0, message = "price.min.error")
    private double priceTo;

    @Min(value = 0, message = "height.min.error")
    private double heightFrom;

    @Min(value = 0, message = "height.min.error")
    private double heightTo;

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

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public double getHeightFrom() {
        return heightFrom;
    }

    public void setHeightFrom(double heightFrom) {
        this.heightFrom = heightFrom;
    }

    public double getHeightTo() {
        return heightTo;
    }

    public void setHeightTo(double heightTo) {
        this.heightTo = heightTo;
    }
}
