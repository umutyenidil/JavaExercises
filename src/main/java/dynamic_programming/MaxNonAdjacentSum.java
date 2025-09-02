package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNonAdjacentSum {

    public static void run(String[] args) {
        System.out.println(maxNonAdjacentSum2(List.of(2, 4, 5, 12, 7)));
    }

    private static int maxNonAdjacentSum1(List<Integer> arr) {
        return maxNonAdjacentSum1(arr, 0);
    }

    private static int maxNonAdjacentSum1(List<Integer> arr, int i) {
        if (i >= arr.size()) return 0;

        var nonAdjacent = arr.get(i) + maxNonAdjacentSum1(arr, i + 2);
        var next = maxNonAdjacentSum1(arr, i + 1);
        return Math.max(nonAdjacent, next);
    }

    private static int maxNonAdjacentSum2(List<Integer> arr) {
        return maxNonAdjacentSum2(arr, 0, new HashMap<>());
    }

    private static int maxNonAdjacentSum2(List<Integer> arr, int i, Map<Integer, Integer> memo) {
        if (i >= arr.size()) return 0;

        if (memo.containsKey(i)) return memo.get(i);

        var nonAdjacent = arr.get(i) + maxNonAdjacentSum2(arr, i + 2, memo);
        var next = maxNonAdjacentSum2(arr, i + 1, memo);
        var result = Math.max(nonAdjacent, next);
        memo.put(i, result);
        return result;
    }
}
