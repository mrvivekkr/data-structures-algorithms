import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 399. Evaluate Division - Graph + DFS solution
 * Given equations like a/b = 2.0, b/c = 3.0, find query results like a/c = ?
 */
public class EvaluateDivision {

    /**
     * Main method: Build graph from equations, then answer all queries using DFS
     * Time: O(Q * (V + E)) where Q=queries, V=variables, E=equations
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build adjacency list graph with bidirectional weighted edges
        Map<String, Map<String,Double>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];

        // Process each query independently
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String source = query.get(0);
            String dest = query.get(1);

            // Quick reject: if either variable doesn't exist in graph
            if(!(graph.containsKey(source) && graph.containsKey(dest))){
                res[i] = -1.0;
            } else {
                // Fresh visited map for each query (independent DFS)
                Map<String, Boolean> visited = new HashMap<>();
                res[i] = dfs(source, dest, graph, visited);
            }
        }
        return res;
    }

    /**
     * Build undirected weighted graph from equations
     * For each a/b = k, store: a->b = k, b->a = 1/k (bidirectional)
     */
    public Map<String, Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String,Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);  // Source variable
            String b = equations.get(i).get(1);  // Target variable
            double ratio = values[i];            // a/b = ratio

            // Initialize adjacency lists if missing
            graph.computeIfAbsent(a, k -> new HashMap<>());
            graph.computeIfAbsent(b, k -> new HashMap<>());

            // Bidirectional edges: a->b = ratio, b->a = 1/ratio
            graph.get(a).put(b, ratio);
            graph.get(b).put(a, 1.0 / ratio);
        }
        return graph;
    }

    /**
     * DFS: Find path multiplier from source to dest
     * Returns: product of edge weights along path, or -1.0 if no path
     */
    public Double dfs(String source, String dest, Map<String, Map<String,Double>> graph, Map<String,Boolean> visited ){
        // Base case: found target (any node / itself = 1.0)
        if(source.equals(dest))
            return 1.0;

        // Mark current node as visited to prevent cycles
        visited.put(source, true);

        // Explore all neighbors
        Map<String, Double> neighbors = graph.get(source);
        for(Map.Entry<String, Double> edge : neighbors.entrySet()){
            String next = edge.getKey();
            Double weight = edge.getValue();

            // Skip visited nodes (cycle prevention)
            if(!visited.getOrDefault(next, false)){
                Double pathMultiplier = dfs(next, dest, graph, visited);

                // Path found! Multiply current edge by remaining path
                if(pathMultiplier != -1.0)
                    return weight * pathMultiplier;
            }
        }
        // No path found from this source
        return -1.0;
    }

    /**
     * Test harness with LeetCode example
     * Expected: [6.0, 0.5, -1.0, 1.0, -1.0]
     */
    public static void main(String[] args){
        EvaluateDivision solution = new EvaluateDivision();
        List<List<String>> equations = List.of(
                List.of("a", "b"),  // a/b = 2.0
                List.of("b", "c")   // b/c = 3.0
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(
                List.of("a", "c"),  // 6.0
                List.of("b", "a"),  // 0.5
                List.of("a", "e"),  // -1.0
                List.of("a", "a"),  // 1.0
                List.of("x", "x")   // -1.0
        );
        double[] output = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(output));
    }
}
