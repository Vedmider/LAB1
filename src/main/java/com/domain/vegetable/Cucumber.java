package com.domain.vegetable;

import com.domain.Color;

public class Cucumber extends AbstractVegetable {

    private VegetableType vegetableType = VegetableType.FRUIT;
    private String name = "Cucumber";
    private Color color = Color.GREEN;
    private int weight;
    private int calorificValue = 1;

    public Cucumber(int weight) {
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
        if (!(o instanceof Cucumber)) {
            return false;
        }

        Cucumber cucumber = (Cucumber) o;

        return vegetableType == cucumber.getVegetableType() &&
                color == cucumber.getColor() &&
                weight == cucumber.getWeight() &&
                calorificValue == cucumber.getCalorificValue();
    }
}
