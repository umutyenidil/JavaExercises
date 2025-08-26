package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {

    public static void run(String[] args) {
        System.out.println(tribonacci2(40));
    }

    public static int tribonacci1(int n) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;

        return tribonacci1(n - 1) + tribonacci1(n - 2) + tribonacci1(n - 3);
    }

    public static int tribonacci2(int n) {
        return tribonacci2(n, new HashMap<>());
    }

    public static int tribonacci2(int n, Map<Integer, Integer> memo) {
        memo.put(0, 0);
        memo.put(1, 0);
        memo.put(2, 1);

        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, tribonacci2(n - 1, memo) + tribonacci2(n - 2, memo) + tribonacci2(n - 3, memo)) ;

        return memo.get(n);
    }
}
