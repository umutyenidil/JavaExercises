package dynamic_programming;

import java.util.Arrays;

public class GridTraveler2D {

    public static void run(String[] args) {
        System.out.println(travelGrid(3, 3));
    }


    // time  => O(m*n)
    // space => O(m*n)
    public static int travelGrid(int m, int n) {
        int[][] grid = new int[m + 1][n + 1];

        grid[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int current = grid[i][j];
                if (i + 1 <= m) grid[i + 1][j] += current;
                if (j + 1 <= n) grid[i][j + 1] += current;
            }
        }

        return grid[m][n];
    }
}
