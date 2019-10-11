package com.domain.vegetable;

import com.domain.Color;

public class Onion extends AbstractVegetable {

    private VegetableType vegetableType = VegetableType.BULB;
    private String name = "Onion";
    private Color color = Color.WHITE;
    private int weight;
    private int calorificValue = 3;

    public Onion(int weight){
        this.weight = weight;
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
        if (!(o instanceof Onion)) {
            return false;
        }

        Onion onion = (Onion) o;

        return vegetableType == onion.getVegetableType() &&
                color == onion.getColor() &&
                weight == onion.getWeight() &&
                calorificValue == onion.getCalorificValue();
    }
}
