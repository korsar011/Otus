package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(150);
        Orange orange1 = new Orange(170);
        Box <Apple> appleBox = new Box<>(apple1);
        Box <Orange> orangeBox = new Box<>(orange1);
        Box <Fruit> fruitBox = new Box <>(apple1, orange1);

        //Преверяем сравнение коробок через compareTo
        System.out.println("Результат сравнения коробок: " + appleBox.compareTo(orangeBox));

        //Проверяем сравнение по условиям задачи (True/false)
        System.out.println("Результат сравнения коробок: " + appleBox.compare(orangeBox));

        //Проверяем перемещение коробок
        Box <Apple> appleBox1 = new Box<>();
        appleBox1.transferFruits(appleBox);
        System.out.println("Проверяем, что коробка пустая: " + appleBox);
        System.out.println("Проверяем, что фрукты переместились: " + appleBox1);

        //Проверяем добавление одного фрукта
        Orange orange2 = new Orange(153);
        orangeBox.addFruit(orange2);
        System.out.println("Проверяем, что фрукт добавлен: " + orangeBox);

        //Проверяем добавление листа с фруктами
        Apple apple2 = new Apple(123);
        Apple apple3 = new Apple(197);
        ArrayList<Apple> apples = new ArrayList<>(List.of(apple2, apple3));
        appleBox.addFruits(apples);
        System.out.println("Проверяем, что лист с фруктами добавлен: " + appleBox);
    }


}
