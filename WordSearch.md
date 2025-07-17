# Word Search

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/word-search/](https://leetcode.com/problems/word-search/)

---

### 🧠 Problem Statement

Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same cell may not be used more than once.

---

### 🧪 Examples

#### Example 1:
**Input:**  
board =
```
[["A","B","C","E"],  
 ["S","F","C","S"],  
 ["A","D","E","E"]]
```  
word = `"ABCCED"`  
**Output:** `true`

#### Example 2:
**Input:**  
board =
```
[["A","B","C","E"],  
 ["S","F","C","S"],  
 ["A","D","E","E"]]
```  
word = `"SEE"`  
**Output:** `true`

#### Example 3:
**Input:**  
board =
```
[["A","B","C","E"],  
 ["S","F","C","S"],  
 ["A","D","E","E"]]
```  
word = `"ABCB"`  
**Output:** `false`

---

### 💡 Approach

We use **Backtracking** to recursively explore all possible paths to match the word.

### Steps:
1. Start from each cell that matches the first character of `word`.
2. From the current cell, recursively try to match the next character in 4 directions: up, down, left, and right.
3. Track visited cells using a boolean matrix to avoid reusing a cell.
4. If all characters are matched, return `true`.
5. Use backtracking to unmark visited cells if a path does not lead to a solution.

---

### ✅ Time Complexity: O(M × N × 4^L)
Where M × N is the number of cells, and L is the length of the word.

### ✅ Space Complexity: O(M × N)
For the `visited` matrix and recursion stack.

---

### 📌 Tags
`Backtracking` `DFS` `Matrix` `String Matching`
