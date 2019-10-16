package com.entity;

import com.domain.Color;
import com.domain.vegetable.VegetableType;

public class VegetableEntity {
    private int id;
    private String name;
    private VegetableType type;
    private Color color;
    private int calorificValue;
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public VegetableType getType() {
        return type;
    }

    public void setType(VegetableType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCalorificValue() {
        return calorificValue;
    }

    public void setCalorificValue(int calorificValue) {
        this.calorificValue = calorificValue;
    }
}
