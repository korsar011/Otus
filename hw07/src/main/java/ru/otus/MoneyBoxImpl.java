package ru.otus;

import ru.otus.Interfaces.MoneyBox;

import java.util.*;

public class MoneyBoxImpl implements MoneyBox {
    private Map <Integer, Integer> moneyMap = new HashMap<>();

    public Map<Integer, Integer> getMoneyMap() {
        return moneyMap;
    }

    public MoneyBoxImpl(List<Integer> denominations){
        for (int denomination : denominations) {
            moneyMap.put(denomination, 0);
        }
    }

    @Override
    public String toString() {
        return "MoneyBox{" +
                "moneyMap=" + moneyMap +
                '}';
    }

}

