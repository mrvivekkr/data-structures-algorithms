# Detect Cycle in Directed Graph

**Difficulty**: Medium  
**Tags**: Graph, DFS, Recursion, Cycle Detection

---

## 🧠 Problem

Given the number of vertices `V` and a list of directed edges, determine whether the graph contains a cycle or not.

---

## 🔍 Approach

We use **Depth-First Search (DFS)** and track:
- `visited[]` — to mark nodes we've visited.
- `recStack[]` — to track nodes in the current DFS path (to detect back edges).

If during DFS, we revisit a node that’s already in the `recStack`, we’ve detected a **cycle**.

---

## 💻 Code

See `DetectCycleInDirectedGraph.java`

---

## 🧪 Examples

### Example 1:

Input:
V = 4
Edges = [[0,1],[0,2],[1,2],[2,0],[2,3]]

Output:
true

Explanation:
There's a cycle: 0 → 1 → 2 → 0


### Example 2:

Input:
V = 4
Edges = [[0,1],[0,2],[1,2],[2,3]]

Output:
false

### Example 3:

Input:
V = 5
Edges = [[0,1],[2,3],[3,4],[4,3]]

Output:
true

Explanation:
Cycle between 3 and 4.


---

## ✅ Time Complexity

- O(V + E)

## ✅ Space Complexity

- O(V) for visited[] and recStack[]

