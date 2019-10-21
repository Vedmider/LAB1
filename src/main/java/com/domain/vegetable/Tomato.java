package com.domain.vegetable;

import com.domain.Color;

public class Tomato extends AbstractVegetable {

    private int id;
    private VegetableType vegetableType = VegetableType.FRUIT;
    private String name = "Tomato";
    private Color color = Color.RED;
    private int weight;
    private int calorificValue = 2;

    public Tomato(int weight){
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
        if (!(o instanceof Tomato)) {
            return false;
        }

        Tomato tomato = (Tomato) o;

        return vegetableType == tomato.getVegetableType() &&
                color == tomato.getColor() &&
                weight == tomato.getWeight() &&
                calorificValue == tomato.getCalorificValue();
    }

}
