package ru.otus;

import ru.otus.Interfaces.Calculator;
import ru.otus.Interfaces.DenominatorInit;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        DenominatorInit denominatorInit = new DenominatorInitImpl();
        System.out.println("Введите номиналы купюр, которые должен принимать банкомат. Для завершения введите 'start':");

        MoneyBoxImpl moneyBox = new MoneyBoxImpl(denominatorInit.initializeDenominator());

        ATMServiceImpl atmService = new ATMServiceImpl(moneyBox.getMoneyMap());

        //Это должен считать автоматом банкомат, но в задаче сказано не делать лишних классов.Поэтому прописал вручную, сколько пользователь внес купюр.
        atmService.putMoney(100, 5); // Добавить 5 купюр номиналом 10
        atmService.putMoney(500, 10); // Добавить 10 купюр номиналом 50
        atmService.putMoney(200, 2); // Попытка добавления купюр с неверным номиналом

        // Вывести состояние купюр в MoneyBox
        Calculator calculator = new CalculatorImpl(moneyBox.getMoneyMap());
        calculator.showDenomination();
        calculator.calculateTotalAmount();

        System.out.print("Введите сумму для выдачи: ");
        Scanner scanner = new Scanner(System.in);
        int withdrawalAmount = scanner.nextInt();
        atmService.getMoney(withdrawalAmount);
        calculator.calculateTotalAmount();
    }
    }




