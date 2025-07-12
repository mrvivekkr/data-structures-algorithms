# Topological Sort

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge `u → v`, vertex `u` comes before `v` in the ordering.

## Example:

**Input:**
Vertices: 6
Edges: [[2, 3], [3, 1], [4, 0], [4, 1], [5, 0], [5, 2]]


**Graph Representation:**

5 → 0 ← 4
↓       ↓
2 → 3 → 1


**Output:**
[5, 4, 2, 3, 1, 0] // One possible topological order


## Approach:

- Construct an adjacency list
- Perform DFS
- Push nodes to a stack **after** visiting all children (post-order)
- Reverse the stack for result

Time Complexity: `O(V + E)`  
Space Complexity: `O(V + E)`  



