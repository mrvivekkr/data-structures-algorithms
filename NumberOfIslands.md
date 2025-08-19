# Number of Islands

## Problem
Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are surrounded by water.

---

## Approach
1. **Traverse the Grid**:
    - Iterate through each cell of the grid.
    - When a land cell `'1'` is found that has not been visited, it represents a new island.

2. **Depth-First Search (DFS)**:
    - Use DFS to explore the entire island starting from the current land cell.
    - Mark each connected land cell as visited to avoid counting it again.
    - Only explore in 4 directions: up, down, left, right.

3. **Count Islands**:
    - Each DFS traversal corresponds to discovering one island.
    - Increment the island count accordingly.

---

## Example Walkthrough

### Example 1
**Input:**
[
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]

**Output:**


1


### Example 2
**Input:**


[
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]

**Output:**


3


---

### 📌 Tags: `Graph`, `DFS`, `BFS`, `Matrix Traversal`, `Medium`
