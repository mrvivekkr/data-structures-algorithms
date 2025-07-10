# Lowest Common Ancestor of a Binary Tree

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

---

### 🧠 Problem Statement

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

> “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow a node to be a descendant of itself).”

---

### 🧪 Examples

#### Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3

#### Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5

#### Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

---

### 💡 Approach

- Traverse the tree recursively.
- If current node is `null`, return `null`.
- If current node is either `p` or `q`, return the node.
- Recursively find LCA in left and right subtrees.
- If both calls return non-null → current node is the LCA.
- Else return whichever subtree returned a non-null node.

---

### ✅ Time Complexity

- **O(n)** — We visit every node once.

### ✅ Space Complexity

- **O(h)** — Call stack in the worst case (`h` = tree height).

---

### 📌 Tags: `Binary Tree`, `DFS`, `Recursion`, `LCA`
