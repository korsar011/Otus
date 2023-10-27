package ru.otus;

import ru.otus.Interfaces.ATMService;

import java.util.*;

public class ATMServiceImpl implements ATMService {
    private Map <Integer, Integer> moneyMap;

    public ATMServiceImpl(Map moneyMap){
        this.moneyMap = moneyMap;
    }

    public void putMoney(int denomination, int amount) {
        if (moneyMap.containsKey(denomination)) {
            int currentAmount = moneyMap.get(denomination);
            moneyMap.put(denomination, currentAmount + amount);
        } else {
            System.out.println("Invalid denomination: " + denomination);
        }
    }

    public void getMoney(int amount) {
        Map<Integer, Integer> denominationsAvailable = new HashMap<>(moneyMap); // Создаем копию доступных номиналов

        List<Integer> sortedDenominations = new ArrayList<>(denominationsAvailable.keySet());
        Collections.sort(sortedDenominations, Collections.reverseOrder()); // Сортируем номиналы в порядке убывания

        Map<Integer, Integer> denominationsToWithdraw = new HashMap<>();

        for (int denomination : sortedDenominations) {
            int numBanknotes = amount / denomination;
            if (numBanknotes > 0 && denominationsAvailable.containsKey(denomination)) {
                int availableBanknotes = denominationsAvailable.get(denomination);
                int banknotesToWithdraw = Math.min(numBanknotes, availableBanknotes);
                amount -= denomination * banknotesToWithdraw;
                denominationsToWithdraw.put(denomination, banknotesToWithdraw);
            }
        }

        if (amount == 0) {
            for (Map.Entry<Integer, Integer> entry : denominationsToWithdraw.entrySet()) {
                int denomination = entry.getKey();
                int banknotes = entry.getValue();
                moneyMap.put(denomination, moneyMap.get(denomination) - banknotes);
            }
            System.out.println("Выдано:");
            for (Map.Entry<Integer, Integer> entry : denominationsToWithdraw.entrySet()) {
                int denomination = entry.getKey();
                int banknotes = entry.getValue();
                System.out.println("Номинал " + denomination + ": " + banknotes + " купюр");
            }
        } else {
            System.out.println("Невозможно выдать указанную сумму.");
        }
    }

}
