# 🎯 Find First and Last Position of Element in Sorted Array

## 📘 Problem Statement
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given target value.

If the target is not found in the array, return `[-1, -1]`.

You must write an algorithm with **O(log n)** runtime complexity.

---

## ✅ Examples
### Example 1:
**Input:**  
`nums = [5,7,7,8,8,10], target = 8`  
**Output:**  
`[3,4]`

### Example 2:
**Input:**  
`nums = [5,7,7,8,8,10], target = 6`  
**Output:**  
`[-1,-1]`

### Example 3:
**Input:**  
`nums = [], target = 0`  
**Output:**  
`[-1,-1]`

---

## 💡 Approach & Complexity
We use **binary search twice**:
1. Once to find the **first occurrence** (left boundary) of the target.
2. Once to find the **last occurrence** (right boundary).

This ensures **O(log n)** complexity.

- Start with `left = 0` and `right = n-1`.
- Compute `mid = (left + right) / 2`.
- If `nums[mid] == target`, record the index and continue searching in the respective half (left for first occurrence, right for last occurrence).
- Adjust `left` and `right` accordingly until the search completes.

### ⏱️ Complexity Analysis
- **Time Complexity:** `O(log n)` (binary search)
- **Space Complexity:** `O(1)` (constant extra space)

---

### 📌 Tags: `Binary Search`, `Array`, `Medium`
