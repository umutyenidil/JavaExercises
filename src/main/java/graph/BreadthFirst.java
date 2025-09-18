package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadthFirst {
    public static void run(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c"));
        graph.put("b", List.of("d"));
        graph.put("c", List.of("e"));
        graph.put("d", List.of("f"));
        graph.put("e", List.of());
        graph.put("f", List.of());

        breadthFirst(graph, "a");
    }

    private static void breadthFirst(Map<String, List<String>> graph, String source) {
        List<String> queue = new ArrayList<>();
        queue.add(source);

        while (queue.size() > 0) {
            String current = queue.removeFirst();

            System.out.println("[LOG]: current >> " + current);

            for (String neighbor : graph.get(current)) {
                queue.addFirst(neighbor);
            }
        }
    }
}
