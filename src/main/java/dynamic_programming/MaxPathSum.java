package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPathSum {
    public static void run(String[] args) {
        var firstRow = List.of(1, 3, 12);
        var secondRow = List.of(5, 6, 2);
        var rows = List.of(firstRow, secondRow);

        System.out.println(maxPathSum2(rows));
    }

    private static int maxPathSum1(List<List<Integer>> grid) {
        return maxPathSum1(grid, 0, 0);
    }

    private static int maxPathSum1(List<List<Integer>> grid, int x, int y) {
        if (x == grid.size() || y == grid.get(x).size()) return Integer.MIN_VALUE;
        if (x == grid.size() - 1 && y == grid.get(x).size() - 1) return grid.get(x).get(y);

        var max = Math.max(maxPathSum1(grid, x + 1, y), maxPathSum1(grid, x, y + 1));
        return max + grid.get(x).get(y);
    }

    private static int maxPathSum2(List<List<Integer>> grid) {
        return maxPathSum2(grid, 0, 0, new HashMap<List<Integer>, Integer>());
    }

    private static int maxPathSum2(List<List<Integer>> grid, int x, int y, Map<List<Integer>, Integer> memo) {
        if (x == grid.size() || y == grid.get(x).size()) return Integer.MIN_VALUE;
        if (x == grid.size() - 1 && y == grid.get(x).size() - 1) return grid.get(x).get(y);

        var pos = List.of(x, y);
        if (memo.containsKey(pos)) return memo.get(pos);

        var max = Math.max(maxPathSum2(grid, x + 1, y, memo), maxPathSum2(grid, x, y + 1, memo));
        var result = max + grid.get(x).get(y);
        memo.put(pos, result);
        return result;
    }
}
