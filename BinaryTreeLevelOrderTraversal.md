# Binary Tree Level Order Traversal

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/binary-tree-level-order-traversal/](https://leetcode.com/problems/binary-tree-level-order-traversal/)

---

### 🧠 Problem Statement

Given the root of a binary tree, return the level order traversal of its nodes' values.  
(i.e., from left to right, level by level).

---

### 🧪 Examples

#### Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

#### Example 2:
Input: root = [1]
Output: [[1]]

#### Example 3:
Input: root = []
Output: []

---

### 💡 Approach

- Use a **queue** to perform a **Breadth-First Search (BFS)** traversal.
- For each level:
    - Record the number of nodes (`levelSize`).
    - Process and collect values of those nodes.
    - Add their children to the queue for the next level.

---

### ✅ Time Complexity

- **O(n)** — where `n` is the number of nodes in the tree.

### ✅ Space Complexity

- **O(n)** — for the output list and the queue used in traversal.

---

### 📌 Tags: `Binary Tree`, `BFS`, `Queue`, `Level Order Traversal`
