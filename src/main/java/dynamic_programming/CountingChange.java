package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingChange {
    public static void run(String[] args) {
        System.out.println(countingChange2(9999, List.of(1, 2, 3)));
    }

    private static int countingChange1(int amount, List<Integer> coins) {
        return countingChange1(amount, coins, 0);
    }

    private static int countingChange1(int amount, List<Integer> coins, int index) {
        if (amount == 0) return 1;
        if(index >= coins.size()) return 0;

        int value = coins.get(index);

        int totalWays = 0;
        for (int quantity = 0; quantity * value <= amount; quantity++) {
            int subAmount = amount - (quantity * value);
            totalWays += countingChange1(subAmount, coins, index + 1);
        }

        return totalWays;
    }

    private static int countingChange2(int amount, List<Integer> coins) {
        return countingChange2(amount, coins, 0, new HashMap<>());
    }

    private static int countingChange2(int amount, List<Integer> coins, int index, Map<Integer, Integer> memo) {
        if (amount == 0) return 1;
        if(index >= coins.size()) return 0;

        if(memo.containsKey(index)) return memo.get(index);

        int value = coins.get(index);

        int totalWays = 0;
        for (int quantity = 0; quantity * value <= amount; quantity++) {
            int subAmount = amount - (quantity * value);
            totalWays += countingChange2(subAmount, coins, index + 1, memo);
        }

        memo.put(index, totalWays);

        return totalWays;
    }
}
