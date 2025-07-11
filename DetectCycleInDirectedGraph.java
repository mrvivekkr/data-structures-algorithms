import java.util.ArrayList;
/**
 * Problem: Detect Cycle in a Directed Graph
 * Given the number of vertices V and a list of directed edges,
 * determine whether the graph contains a cycle.
 */
public class DetectCycleInDirectedGraph {
    /**
     * Determines if the graph contains a cycle.
     */
    public boolean isCyclic(int V, int[][] edges){
        ArrayList<Integer>[] adj = constructAdjList(V, edges);
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            visited[i] = true;
            if(isCyclicUtil(adj, visited, i))
                return true;
        }
        return false;
    }

    /**
     * Helper to build adjacency list.
     */
    private ArrayList<Integer>[] constructAdjList(int V, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
        }
        return adj;
    }

    /**
     * DFS-based cycle detection.
     */
    public boolean isCyclicUtil(ArrayList<Integer>[] adj, boolean[] visited, int curr){
        for(int i: adj[curr]){
            if(visited[i])
                return true;
            if(!visited[i]) {
                visited[i] = true;
                if (isCyclicUtil(adj, visited, i))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        DetectCycleInDirectedGraph solution = new DetectCycleInDirectedGraph();
        int V = 4; // Number of vertices
        int[][] edges = {{ 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }};
        /*
           Graph:
           0 → 1 → 2 → 0 (cycle)
           ↓       ↓
           2       3
         */
        boolean res = solution.isCyclic(V, edges);
        System.out.println(res);
        edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
         /*
           Graph:
           0 → 1 → 2 → 3 (no cycle)
              ↘
                2
         */
        res = solution.isCyclic(V, edges);
        System.out.println(res);
        edges = new int[][]{{0, 1}, {1, 2}, {2, 0},{2, 3}};
        /*
           Graph:
           0 → 1 → 2 → 0 (cycle)
                   ↓
                   3
         */
        res = solution.isCyclic(V, edges);
        System.out.println(res);
        V=5;
        edges = new int[][] {{0, 1}, {2, 3}, {3, 4}, {4, 3}};
        /*
           Graph:
           0 → 1

           2 → 3 → 4
                ↑   ↓
                 ←──
           (cycle between 3 and 4)
         */
        res = solution.isCyclic(V, edges);
        System.out.println(res);
    };
}
