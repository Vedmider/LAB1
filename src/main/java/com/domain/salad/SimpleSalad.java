package com.domain.salad;

import com.domain.vegetable.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleSalad implements Salad {

    private List<AbstractVegetable> saladComponents;
    private int caloriesCount = 0;

    public SimpleSalad(List<AbstractVegetable> saladComponents) {

        if (saladComponents.isEmpty()) {
            throw new IllegalArgumentException("List can not be empty");
        }
        this.saladComponents = saladComponents;
    }

    @Override
    public String makeSalad() {

        System.out.println("Simple salad is cooked");
        return "Simple salad is cooked";
    }

    public List<AbstractVegetable> getSaladComponents() {
        return saladComponents;
    }

    public int countCalories() {
        if (caloriesCount != 0) {
            return caloriesCount;
        }

        for (AbstractVegetable v : saladComponents) {
            caloriesCount += v.countCalories();
        }
        return caloriesCount;
    }

    public ArrayList<AbstractVegetable> sortByWeight() {
        return saladComponents.stream()
                .sorted(Comparator.comparingInt(AbstractVegetable::getWeight))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<AbstractVegetable> getVegetablesWithCaloriesRange(int minCalories, int maxCalories) {
        if (minCalories > maxCalories
                || minCalories < 1
                || maxCalories < 1){
            throw new IllegalArgumentException();
        }
            return saladComponents.stream()
                    .filter(v -> (v.getCalorificValue() >= minCalories
                            && v.getCalorificValue() <= maxCalories))
                    .collect(Collectors.toList());
    }
}
