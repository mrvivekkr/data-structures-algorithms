# Word Search II

**Platform**: LeetCode  
**Problem Number**: 212  
**Difficulty**: Hard  
**Link**: [https://leetcode.com/problems/word-search-ii/](https://leetcode.com/problems/word-search-ii/)

---

### 🧠 Problem Statement

Given an `m x n` board of characters and a list of strings `words`, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

---

### 🧪 Examples

#### Example 1:
**Input:**  
board =
[["o","a","a","n"],
["e","t","a","e"],
["i","h","k","r"],
["i","f","l","v"]]

words = `["oath","pea","eat","rain"]`  
**Output:** `["eat","oath"]`

---

### 💡 Approach

We use a **Trie** to represent the list of words for efficient prefix checking, combined with **DFS backtracking** on the board to explore all paths that can form a word.

#### Steps:
1. Build a Trie from the list of words.
2. Iterate over each cell of the board.
3. Use DFS to explore adjacent letters, traversing the Trie accordingly.
4. Track visited cells to prevent reuse in the current path.
5. Record words found when reaching Trie nodes marked as word ends.

---

### ✅ Time Complexity: O(M × N × 4^L)

Where M × N is the board size, and L is the maximum word length.

### ✅ Space Complexity: O(Total characters in all words)

For the Trie and recursion stack.

---

### 📌 Tags

`Trie` `Backtracking` `DFS` `Matrix`
