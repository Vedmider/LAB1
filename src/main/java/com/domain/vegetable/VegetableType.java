package com.domain.vegetable;

public enum VegetableType {
    LEAFY("Leafy"),
    BULB("Bulb"),
    ROOT("Root"),
    FRUIT("Fruit");

    private String typeName;

    VegetableType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "VegetableType{typeName=" + typeName + "}";
    }
}
