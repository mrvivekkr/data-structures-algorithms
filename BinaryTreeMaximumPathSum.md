# 🌳 Binary Tree Maximum Path Sum

## 📘 Problem Statement
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.  
A node can only appear in the sequence **at most once**.  
Note that the path does **not need to pass through the root**.

The **path sum** of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the **maximum path sum** of any non-empty path.

---

## ✅ Example
### Example 1:
**Input Tree:**

    -10
    /  \    
    9   20
       /  \
      15   7

**Output:**  
`42`  
**Explanation:** The maximum path is `15 → 20 → 7` which gives `42`.

---

## 💡 Approach & Complexity
We use **DFS recursion with backtracking**:

1. At each node, compute the maximum contribution from its **left** and **right** subtrees.
    - If a contribution is negative, discard it (take `0` instead).
2. Update the global maximum path sum by considering the node + left + right.
3. Return the node value plus the **maximum of left or right contribution** to continue the recursion upwards.

### ⏱️ Complexity Analysis
- **Time Complexity:** `O(n)` (each node is visited once)
- **Space Complexity:** `O(h)` (recursive call stack, where `h` = height of tree)

---

### 📌 Tags: `Binary Tree`, `DFS`, `Dynamic Programming`, `Recursion`, `Hard`


