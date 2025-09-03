package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class SquaresSum {
    public static void run(String[] args) {
        System.out.println(squaresSum2(60));
    }

    private static double squaresSum1(int n) {
        if (n == 0) return 0;

        double minSquares = Double.POSITIVE_INFINITY;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            double numSquares = 1 + squaresSum1(n - square);
            if (numSquares < minSquares) {
                minSquares = numSquares;
            }
        }

        return minSquares;
    }

    private static double squaresSum2(int n) {
        return squaresSum2(n, new HashMap<>());
    }

    private static double squaresSum2(int n, Map<Integer, Double> memo) {
        if (n == 0) return 0;

        if (memo.containsKey(n)) return memo.get(n);

        double minSquares = Double.POSITIVE_INFINITY;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            double numSquares = 1 + squaresSum2(n - square, memo);
            if (numSquares < minSquares) {
                minSquares = numSquares;
            }
        }

        memo.put(n, minSquares);

        return minSquares;
    }
}
