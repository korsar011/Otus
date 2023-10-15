package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box<T>> {
    private ArrayList <T> fruits;

    //Получить список фруктов
    public ArrayList <T> getFruits() {
        return fruits;
    }

    //Если добавить один фрукт
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }
    //Если добавить список фруктов
    public void addFruits(ArrayList<T> additionalFruits) {
        this.fruits.addAll(additionalFruits);
    }

    public Box(T... fruits) {
        this.fruits = new ArrayList<>(List.of(fruits));
    }

    //Общий вес коробки
    int weight (){
        int totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    //Перемещение фруктов
    public Box <T> transferFruits (Box <T> initialBox) {
        if (this == initialBox) {
            throw new IllegalArgumentException("Нельзя пересыпать коробку в саму себя");
        }
        ArrayList<T> fruitsToTransfer = initialBox.getFruits();
        this.fruits.addAll(fruitsToTransfer);
        fruitsToTransfer.clear();
        return this;
    }

    //Сравнение веса коробки
    @Override
    public int compareTo(Box otherBox) {
        return Double.compare(this.weight(), otherBox.weight());
    }

    public boolean compare (Box <?> otherBox){
        return this.compareTo(otherBox) == 0;
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}

