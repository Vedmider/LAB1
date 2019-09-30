package com.domain.vegetable;

import com.domain.Color;

public class Carrot extends AbstractVegetable {

    private VegetableType vegetableType = VegetableType.ROOT;
    private String name = "Carrot";
    private Color color = Color.ORANGE;
    private int weight;
    private int calorificValue = 5;

    public Carrot(int weight) {
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
        if (!(o instanceof Carrot)) {
            return false;
        }

        Carrot carrot = (Carrot) o;

        return vegetableType == carrot.getVegetableType() &&
                color == carrot.getColor() &&
                weight == carrot.getWeight() &&
                calorificValue == carrot.getCalorificValue();
    }
}
