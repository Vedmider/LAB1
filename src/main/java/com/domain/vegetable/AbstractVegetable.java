package com.domain.vegetable;

import com.domain.Color;

public abstract class AbstractVegetable {
    private int id;
    private VegetableType vegetableType;
    private String name;
    private Color color;
    private int weight;
    private int calorificValue;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getName();

    public abstract int countCalories();

    public abstract Color getColor();

    public abstract VegetableType getVegetableType();

    public abstract int getCalorificValue();

    public abstract int getWeight();

}
