package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirst {
    public static void run(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c")); // recursiveDepthFirst icin List.of("c","b") olmali
        graph.put("b", List.of("d"));
        graph.put("c", List.of("e"));
        graph.put("d", List.of("f"));
        graph.put("e", List.of());
        graph.put("f", List.of());

        depthFirst(graph, "a");
    }

    private static void depthFirst(Map<String, List<String>> graph, String start) {
        List<String> stack = new ArrayList<>();
        stack.add(start);

        while (stack.size() > 0) {
            String current = stack.removeLast();
            System.out.println("[LOG]: current >> " + current);
            for (String neighbor : graph.get(current)) {
                stack.add(neighbor);
            }
        }
    }

    private static void recursiveDepthFirst(Map<String, List<String>> graph, String source) {
        System.out.println("[LOG]: current >> " + source);

        if(graph.get(source).size() < 1) return;

        for (String neighbor : graph.get(source)) {
            recursiveDepthFirst(graph, neighbor);
        }
    }
}
