package dynamic_programming;

import java.util.Arrays;

public class Fibonacci {

    public static void run(String[] args) {
        System.out.println(fibonacci4(6));
        System.out.println(fibonacci4(7));
        System.out.println(fibonacci4(8));
        System.out.println(fibonacci4(50));
    }

    private static int fibonacci(int n) {
        int memo1 = 1;
        int memo2 = 0;

        for (int i = 2; i <= n; i++) {
            int temp = memo2 + memo1;

            memo2 = memo1;
            memo1 = temp;
        }

        return memo2;
    }

    // tabulation
    // time  => O(n)
    // space => O(n)
    private static int fibonacci3(int n) {
        int[] memo = new int[n + 3];

        memo[1] = 1;

        for (int i = 0; i <= n; i++) {
            memo[i + 1] += memo[i];
            memo[i + 2] += memo[i];
        }

        return memo[n];
    }

    // dynamic tabulation
    // time  => O(n)
    // space => O(1)
    private static int fibonacci4(int n) {
        if(n < 2) return n;

        int memo1 = 1;
        int memo2 = 1;

        for (int i = 3; i <= n; i++) {
            int temp = memo2 + memo1;
            memo1 = memo2;
            memo2 = temp;
        }

        return memo2;
    }
}
