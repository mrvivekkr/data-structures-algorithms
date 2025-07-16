# N-Queens

**Platform**: LeetCode  
**Difficulty**: Hard  
**Link**: [https://leetcode.com/problems/n-queens/](https://leetcode.com/problems/n-queens/)

---

### 🧠 Problem Statement

The N-Queens puzzle is the problem of placing `n` queens on an `n x n` chessboard  
such that no two queens attack each other.

You must return **all distinct solutions** to the N-Queens puzzle.  
Each solution contains a board configuration represented as a list of strings,  
where `'Q'` represents a queen and `'.'` represents an empty square.

---

### 🧪 Examples:

#### Example 1:
Input: n = 4  
Output: [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]


#### Example 2:
Input: n = 1  
Output: [[Q]]


---

### 💡 Approach

We solve this using **Backtracking**:

- Place queens **row by row**.
- For each cell, check if it's **safe**:
    - No other queen should be in the **same column**.
    - No other queen should be on the **upper-left diagonal**.
    - No other queen should be on the **upper-right diagonal**.
- If safe, place the queen and recursively try the next row.
- If we reach the end (i.e. placed all queens), store the board configuration.
- After recursion, backtrack and try next position.

---

### ✅ Time Complexity: O(N!)
We try placing queens in each column of a row, recursively, with pruning via safety checks.

### ✅ Space Complexity: O(N²)
Used for storing the board state and recursive stack.

---

### 📌 Tags: `Backtracking`, `Recursion`, `DFS`, `Matrix`, `Hard`

