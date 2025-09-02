package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumPossible {
    public static void run(String[] args) {

    }

    private static boolean sumPossible1(int amount, List<Integer> numbers) {
        if(amount == 0) return true;
        else if (amount < 0) return false;

        for(int number : numbers) {
            int subAmount = amount - number;
            if(sumPossible1(subAmount, numbers)) return true;
        }

        return false;
    }

    private static boolean sumPossible2(int amount, List<Integer> numbers) {
        return sumPossible2(amount, numbers, new HashMap<>());
    }

    private static boolean sumPossible2(int amount, List<Integer> numbers, Map<Integer, Boolean> memo) {
        if(memo.containsKey(amount)) return memo.get(amount);
        else if(amount == 0) return true;
        else if (amount < 0) return false;

        for(int number : numbers) {
            int subAmount = amount - number;
            if(sumPossible2(subAmount, numbers)) {
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }
}
