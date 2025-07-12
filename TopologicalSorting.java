import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Topological Sort using DFS
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that
 * for every directed edge u → v, vertex u comes before v in the ordering.
 */
public class TopologicalSorting {

    /**
     * Performs topological sort on the given directed graph.
     * @param v     Number of vertices
     * @param edges List of directed edges
     * @return A list representing topological order
     */
    private List<Integer> topologicalSort(int v, int[][] edges) {
        // Construct adjacency list
        List<Integer>[] adj = new ArrayList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        // Perform DFS for unvisited vertices
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(adj, i, visited, stack);
            }
        }

        // Pop from stack to get ordering
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }

    /**
     * DFS Utility to help with topological sorting
     */
    private void topologicalSortUtil(List<Integer>[] adj, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;
        for (int neighbor : adj[curr]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(adj, neighbor, visited, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        TopologicalSorting solution = new TopologicalSorting();
        int v = 6;
        int[][] edges = {
                {2, 3}, {3, 1}, {4, 0}, {4, 1}, {5, 0}, {5, 2}
        };
        /*
            DAG Representation:
            5 → 0 ← 4
            ↓       ↓
            2 → 3 → 1

            A valid topological order: 5 4 2 3 1 0 (one of many)
         */
        List<Integer> res = solution.topologicalSort(v, edges);
        for (int node : res)
            System.out.print(node + " ");
    }
}
