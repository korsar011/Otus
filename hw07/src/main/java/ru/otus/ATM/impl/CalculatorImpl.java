package ru.otus.ATM.impl;

import ru.otus.ATM.Calculator;
import java.util.Map;

public class CalculatorImpl implements Calculator {
    private Map <Integer, Integer> moneyMap;

    public CalculatorImpl (Map moneyMap){
        this.moneyMap = moneyMap;
    }
    public void calculateTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : moneyMap.entrySet()) {
            int denomination = entry.getKey();
            int amount = entry.getValue();
            totalAmount += denomination * amount;
        }
        System.out.println("Остаток средств в банкомате: " + totalAmount);
    }
    public void showDenomination() {
        System.out.println("\nКоличество купюр в банкомате");
        for (Map.Entry<Integer, Integer> entry : moneyMap.entrySet()) {
            int denomination = entry.getKey();
            int amount = entry.getValue();
            System.out.println("Номинал " + denomination + ": " + amount + " купюр");
        }
    }
}


