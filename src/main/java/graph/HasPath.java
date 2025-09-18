package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HasPath {

    public static void run(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("f", List.of("g", "i"));
        graph.put("g", List.of("h"));
        graph.put("h", List.of());
        graph.put("i", List.of("g", "k"));
        graph.put("j", List.of("i"));
        graph.put("k", List.of());

        String src = "f";
        String dst = "k";
        boolean has = hasPathBreadth(graph, src, dst);
        System.out.println("[LOG]: there is" + (has ? "": "n't" )+ " a path to " + dst + " from " + src);
    }

    private static boolean hasPath(Map<String, List<String>> graph, String src, String dst) {
        if (src.equals(dst)) return true;

        for (String neighbor : graph.get(src)) {
            if (hasPath(graph, neighbor, dst)) return true;
        }

        return false;
    }

    private static boolean hasPathBreadth(Map<String, List<String>> graph, String src, String dst) {
        List<String> queue = new ArrayList<>();
        queue.add(src);

        while (queue.size() > 0) {
            String current = queue.removeFirst();

            if(current.equals(dst)) return true;

            for (String neighbor : graph.get(current)) {
                queue.add(neighbor);
            }
        }

        return false;
    }
}
