package ru.otus.ATM.impl;

import ru.otus.ATM.DenominatorInit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DenominatorInitImpl implements DenominatorInit {
    public static final String stopWord = "start";
    public List<Integer> initializeDenominator (){
        Scanner scanner = new Scanner(System.in);
        List<Integer> denominations = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(stopWord)) {
                break;
            }
            int denomination = Integer.parseInt(input);
            denominations.add(denomination);
        }
        return denominations;
    }
}
