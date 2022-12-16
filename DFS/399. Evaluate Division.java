import java.util.*;
import java.util.HashMap;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build directed weighted graph.
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return result;
    }

    private double getPathWeight(String start, String end, Set<String> visited,
            Map<String, Map<String, Double>> graph) {
        // rejection case
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        // accepting case
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double productWeight = getPathWeight(neighbor.getKey(), end, visited, graph);
                if (productWeight != -1.0) {
                    return neighbor.getValue() * productWeight;
                }
            }

        }
        return -1.0;
    }

    private static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v;

        for (int i = 0; i < equations.size(); i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }
        return graph;
    }
}