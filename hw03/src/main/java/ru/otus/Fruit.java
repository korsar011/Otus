package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class Fruit {
    int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }

    public int getWeight (){
        return weight;
    }
    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }
}
