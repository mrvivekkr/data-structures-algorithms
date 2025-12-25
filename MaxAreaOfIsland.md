# Max Area of Island

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/max-area-of-island/](https://leetcode.com/problems/max-area-of-island/)

---

### 🧠 Problem Statement

Given an `m x n` binary matrix `grid`, return the **maximum area** of an island.  
An island is a group of `1's` connected **4-directionally** (horizontal/vertical).  
All four edges are surrounded by water. Return `0` if no islands exist.

---

### 🧪 Examples:

#### Example 1:
grid = {  
{0,0,1,0,0,0,0,1,0,0,0,0,0},  
{0,0,0,0,0,0,0,1,1,1,0,0,0},  
{0,1,1,0,1,0,0,0,0,0,0,0,0},  
{0,1,0,0,1,1,0,0,1,0,1,0,0},  
{0,1,0,0,1,1,0,0,1,1,1,0,0},  
{0,0,0,0,0,0,0,0,0,0,1,0,0},  
{0,0,0,0,0,0,0,1,1,1,0,0,0},  
{0,0,0,0,0,0,0,1,1,0,0,0,0}  
};  
Output: 6


---

### 💡 Approach

**DFS + Visited Matrix** to explore each island completely:

1. **Iterate through grid**: Find unvisited land cells (`grid[i][j] == 1`)
2. **DFS from each island**: Calculate total connected land cells
3. **Track maximum area**: Update global max during traversal
4. **Mark visited**: Prevent revisiting cells

**Key Insight**: `count += dfs(neighbor)` accumulates all subtree sizes correctly.

---

### ✅ Time Complexity: O(m × n)
- Visit each cell exactly once

### ✅ Space Complexity: O(m × n)
- Visited matrix + recursion stack (worst case: entire grid is land)

---

### 📌 Tags:
`DFS` `Graph` `Matrix` `Island` `Backtracking` `2D Array`

---
