# Symmetric Tree

## 📌 Problem Statement
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

---

## 🔹 Example

### Input Tree:
   1
  / \
 2   2
/ \ / \
3 4 4  3
### Output:
true

---

## 💡 Approach
- Use **recursion** to compare nodes in the left and right subtrees.
- Base cases:
    - Both nodes are `null` → symmetric.
    - Only one is `null` → not symmetric.
    - Values differ → not symmetric.
- Recursively check:
    - Left subtree’s left child vs. right subtree’s right child.
    - Left subtree’s right child vs. right subtree’s left child.

This approach performs a **DFS traversal** while maintaining mirrored checks.

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(n)` – each node is visited once.
- **Space Complexity:** `O(h)` – recursion stack, where `h` is the height of the tree.

---

📌 Tags: Binary Tree, Recursion, DFS, Mirror Tree, Easy