package com.domain.vegetable;

import com.domain.Color;

public class Kale extends AbstractVegetable {

    private int id;
    private VegetableType vegetableType = VegetableType.LEAFY;
    private String name = "Kale";
    private Color color = Color.GREEN;
    private int weight;
    private int calorificValue = 7;

    public Kale(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int countCalories() {
        return weight * calorificValue;
    }

    public Color getColor() {
        return color;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    public int getCalorificValue() {
        return calorificValue;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + vegetableType.name().hashCode();
        result = 31 * result + weight;
        result = 31 * result + vegetableType.name().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Kale)) {
            return false;
        }

        Kale kale = (Kale) o;

        return vegetableType == kale.getVegetableType() &&
                color == kale.getColor() &&
                weight == kale.getWeight() &&
                calorificValue == kale.getCalorificValue();
    }
}
