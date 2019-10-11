package com.domain.salad;

import com.domain.vegetable.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleSaladTest {

    private Carrot carrot;
    private Cucumber cucumber;
    private Kale kale;
    private Onion onion;
    private Tomato tomato;
    private List<AbstractVegetable> vegetableList;

    @Before
    public void setUp(){
        carrot = new Carrot(250);
        cucumber = new Cucumber(150);
        kale = new Kale(50);
        onion = new Onion(200);
        tomato = new Tomato(350);
        vegetableList = new ArrayList<>();
        vegetableList.add(carrot);
        vegetableList.add(cucumber);
        vegetableList.add(kale);
        vegetableList.add(onion);
        vegetableList.add(tomato);
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenVegetableListIsEmpty(){
        thrown.expect(IllegalArgumentException.class);
        SimpleSalad salad = new SimpleSalad(new ArrayList<AbstractVegetable>());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithMessageWhenVegetableListIsEmpty(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("List can not be empty");
        SimpleSalad salad = new SimpleSalad(new ArrayList<AbstractVegetable>());
    }

    @Test
    public void shouldReturn3050WithFullListOfVegetables(){
        int expected = 3050;
        int actual = new SimpleSalad(vegetableList).countCalories();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn600WithListOfOneOnion(){
        List<AbstractVegetable> oneVegetableList = new ArrayList<>();
        oneVegetableList.add(onion);
        int expected = 600;
        int actual = new SimpleSalad(oneVegetableList).countCalories();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenSaladIsCooked(){
        String expected = "Simple salad is cooked";
        String actual = new SimpleSalad(vegetableList).makeSalad();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortSaladComponentsByWeight(){
        ArrayList<AbstractVegetable> expected = new ArrayList<>();
        expected.add(kale); // weight = 50
        expected.add(cucumber); // weight = 150
        expected.add(onion); // weight = 200
        ArrayList<AbstractVegetable> actual = new SimpleSalad(vegetableList).sortByWeight();

        for (int i = 0; i < expected.size(); i++){
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithMinValueGreaterThanMaxValue(){
        thrown.expect(IllegalArgumentException.class);
        new SimpleSalad(vegetableList).getVegetablesWithCaloriesRange(2, 1);
    }

    @Test
    public void shouldReturnVegetableListThatMatchCalorificRangeFromOneToOne(){
        int expected = 1;
        int actual = new SimpleSalad(vegetableList).getVegetablesWithCaloriesRange(1, 1).get(0).getCalorificValue();

        assertEquals(expected, actual);
    }


}
