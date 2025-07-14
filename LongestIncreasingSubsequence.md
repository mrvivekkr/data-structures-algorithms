# Longest Increasing Subsequence

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

---

## 🔍 Problem Statement

A **subsequence** is derived by deleting some or no elements from an array without changing the order of the remaining elements. We need to find the longest subsequence where the values are strictly increasing.

---

## 🧠 Approach

We use **Dynamic Programming**:
- Define an array `lis[]` where `lis[i]` stores the length of the LIS ending at index `i`.
- Initialize all values in `lis[]` as `1`, because every element is an LIS of length 1 by itself.
- For every pair `(j, i)` where `j < i`, if `nums[i] > nums[j]`, it means `nums[i]` can extend the increasing subsequence ending at `j`.
- Update `lis[i] = max(lis[i], lis[j] + 1)`.
- Keep track of the maximum value in `lis[]` for the final result.

---

## 💡 Examples

### Example 1:
**Input:** `nums = [10,9,2,5,3,7,101,18]`  
**Output:** `4`  
**Explanation:** The LIS is `[2,3,7,101]`.

### Example 2:
**Input:** `nums = [0,1,0,3,2,3]`  
**Output:** `4`  
**Explanation:** The LIS is `[0,1,2,3]`.

### Example 3:
**Input:** `nums = [7,7,7,7,7,7,7]`  
**Output:** `1`  
**Explanation:** The LIS is just `[7]`.

---

## ⏱️ Time & Space Complexity

- **Time Complexity:** `O(n^2)`  
  Two nested loops to evaluate all pairs of increasing subsequences.

- **Space Complexity:** `O(n)`  
  Extra space is used to maintain the `lis[]` array.

---
