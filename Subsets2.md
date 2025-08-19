# 90. Subsets II

**Level:** Medium  
**Link:** https://leetcode.com/problems/subsets-ii/

---

## 🧠 Problem

Given an integer array `nums` that may contain duplicates, return **all possible subsets** (the power set).  
The solution set **must not** contain duplicate subsets. Return the solution in any order.

---

## 🧪 Examples

**Example 1**  
Input: `nums = [1,2,2]`  
Output:  
[[],[1],[1,2],[1,2,2],[2],[2,2]]

**Example 2**  
Input: `nums = [0]`  
Output:  
[[],[0]]


---

## 💡 Approach

We use **Backtracking** to explore all subsets and ensure uniqueness.

1. **Sort the array** so equal numbers are adjacent.
2. Build subsets by choosing to include or exclude each element as we recurse from left to right.
3. **De-duplication strategy used in the code:**  
   Before adding a subset into the result, we check if it already exists (`output.contains(list)`).
   
---

## ✅ Time Complexity

- Worst-case around **O(2^n · n)** for generating and copying all subsets.
- Using `output.contains(...)` for de-dup may add extra overhead.

## ✅ Space Complexity

- **O(2^n · n)** to store all subsets, plus **O(n)** recursion depth.

---

### 📌 Tags: `Backtracking`, `Array`, `Power Set`, `Subsets`, `Sorting`
