package dynamic_programming;

import java.util.Arrays;

public class Fibonacci {

    public static void run(String[] args) {
        System.out.println(fibonacci(500));
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
}
