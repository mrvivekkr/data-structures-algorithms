# Binary Tree Zigzag Level Order Traversal

**Platform**: LeetCode  
**Problem Number**: 103  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

---

### 🧠 Problem Statement

Given the `root` of a binary tree, return the **zigzag level order traversal** of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

---

### 🧪 Examples

#### Example 1:
**Input:**  
root = 
```
    3
   / \
  9  20
    /  \
   15   7
```
**Output:** `[[3],[20,9],[15,7]]`

#### Example 2:
**Input:**  
root = 1
**Output:** `[[1]]`

#### Example 3:
**Input:**  
root = `[]`  
**Output:** `[]`

---

### 💡 Approach

We use **Two Stacks Iterative Traversal** to achieve zigzag order naturally.

### Steps:
1. Initialize two stacks: `current` (left→right levels) and `next` (right→left levels).
2. Start with root in current stack.
3. While either stack is not empty:
    - Process current stack completely, adding nodes to result in LIFO order.
    - Push children to next stack in **left→right order**.
    - Swap stack roles and process next stack, pushing children in **right→left order**.
4. The stack LIFO property + controlled child push order creates perfect zigzag.

---

### ✅ Time Complexity: O(N)
Where N is the number of nodes in the tree. Each node is visited exactly once.

### ✅ Space Complexity: O(N)
For the stacks (worst case: skewed tree) and output storage.

---

### 📌 Tags
`Tree` `BFS` `Stack` `Level Order Traversal`

