# N-Queens II

**Platform**: LeetCode  
**Problem Number**: 52  
**Difficulty**: Hard  
**Link**: [https://leetcode.com/problems/n-queens-ii/](https://leetcode.com/problems/n-queens-ii/)

---

### 🧠 Problem Statement

The *n*-queens puzzle is the problem of placing *n* queens on an *n* × *n* chessboard such that no two queens attack each other.

Given an integer *n*, return the **number of distinct solutions** to the *n*-queens puzzle.

---

### 🧪 Examples

#### Example 1:
**Input:**  
n = 4  
**Output:** 2  
**Explanation:**  
There are two distinct solutions for the 4-queens puzzle as shown.

#### Example 2:
**Input:**  
n = 1  
**Output:** 1

---

### 💡 Approach

Backtracking is used to explore all valid placements of queens row by row.

**Key points:**
- Each row can only have one queen.
- Before placing a queen, check if the position is safe (no other queen on the same column, row, or diagonals).
- Use recursion to try placing queens on subsequent rows after placing one on the current row.
- Backtrack by removing queens and exploring alternate positions to find all solutions.
- Count each valid full placement when queens are safely placed on all rows.

---

### 📌 Implementation Details

- Use a 2D integer array `board` to represent the chessboard (`1` means queen placed).
- `isSafe` function checks if placing a queen at `(row, col)` is safe on the board from attacks horizontally, vertically, and diagonally.
- Recursive `dfs` tries to place a queen in all safe columns of the current row and accumulates counts of valid solutions.
- Backtrack after each attempt to explore other possibilities.

---

### ✅ Time Complexity
O(N!) — the number of valid N-queen configurations (pruned by safety checks)

### ✅ Space Complexity
O(N²) due to the `board` matrix and recursion stack of depth N.

---

### 📌 Tags

`Backtracking` `DFS` `N-Queens` `Matrix` `Recursion`
