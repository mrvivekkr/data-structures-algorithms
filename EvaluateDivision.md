# Evaluate Division

## Problem

Given a list of variable pairs `equations` and corresponding `values`, evaluate division queries.

**Input:**  
`equations = [["a","b"],["b","c"]], values = [2.0,3.0]`  
`queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]`

**Output:** `[6.0, 0.5, -1.0, 1.0, -1.0]`

**Explanation:**
- `a/c = (a/b) × (b/c) = 2.0 × 3.0 = 6.0`
- `b/a = 1/(a/b) = 1/2.0 = 0.5`
- `a/e = -1.0` (e undefined)
- `a/a = 1.0`
- `x/x = -1.0` (x undefined)

---

## Approach

**Graph + DFS (Adjacency List)**

### 1. Graph Construction
a → b: 2.0 b → a: 0.5
b → c: 3.0 c → b: 0.333

- For `a/b = k`: store `a→b = k`, `b→a = 1/k`
- **Bidirectional weighted graph**

### 2. DFS Path Finding
For query `a/c`:
a → b (2.0) → c (3.0) = 6.0
- **Visited tracking** prevents cycles
- **Multiply edge weights** along path
- **Early termination** when path found

### Steps:
1. Build graph from equations
2. For each query:
    - If source/dest missing → `-1.0`
    - Else → `DFS(source, dest)`

---

## Time Complexity

- **O(Q × (V + E))** where:
    - `Q` = queries
    - `V` = variables
    - `E` = equations

## Space Complexity

- **O(E + V)** for graph + recursion stack

---
## Tags

`Graph` `DFS` `Adjacency List` `Path Finding` `Ratio Propagation` `Weighted Graph`


