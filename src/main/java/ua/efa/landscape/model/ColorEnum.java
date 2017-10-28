package ua.efa.landscape.model;

public enum ColorEnum {
    GREEN("green"),
    YELLOW("yellow"),
    RED("red"),
    BLUE("blue"),
    ORANGE("orange"),
    LIGHT_GREEN("light green"),
    PINK("pink");

    private String displayName;
    private String value;

    ColorEnum(String name){
        displayName = name;
        value = toString();
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getValue() {
        return value;
    }
}
