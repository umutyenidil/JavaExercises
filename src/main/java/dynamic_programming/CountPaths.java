package dynamic_programming;

import java.util.*;

public class CountPaths {
    public static void run(String[] args) {
        var columnList = new ArrayList<String>();
        columnList.add("A");
        columnList.add("B");
        columnList.add("C");

        var rowList = new ArrayList<List<String>>();
        rowList.add(columnList);
        rowList.add(columnList);
        rowList.add(columnList);

        System.out.println(countPaths(rowList));
    }

    public static int countPaths(List<List<String>> grid) {
        return countPaths(grid, 0, 0, new HashMap<>());
    }

    public static int countPaths(List<List<String>> grid, int r, int c, Map<List<Integer>, Integer> memo) {
        if (r == grid.size() - 1 && c == grid.get(r).size() - 1) return 1;
        if (r == grid.size() || c == grid.get(r).size()) return 0;
        if (grid.get(r).get(c).isEmpty()) return 0;

        var pos = List.of(r, c);
        if (memo.containsKey(pos)) return memo.get(pos);

        return countPaths(grid, r + 1, c, memo) + countPaths(grid, r, c + 1, memo);
    }
}
