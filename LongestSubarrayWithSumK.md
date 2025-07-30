# Longest Subarray with Sum K

## Problem

Given an array `arr[]` containing integers and an integer `k`, your task is to find the **length of the longest subarray** where the sum of its elements is equal to the given value `k`. If no such subarray exists, return `0`.

---

## Examples

### Example 1
**Input:**  
arr = [10, 5, 2, 7, 1, -10], k = 15  
**Output:** 6  
**Explanation:** The entire array sums to 15.

### Example 2
**Input:**  
arr = [-5, 8, -14, 2, 4, 12], k = -5  
**Output:** 5  
**Explanation:** Subarray `[-5, 8, -14, 2, 4]` has sum -5.

### Example 3
**Input:**  
arr = [10, -10, 20, 30], k = 5  
**Output:** 0  
**Explanation:** No subarray has sum equal to 5.

---

## Approach

We use a **HashMap** to store the earliest index where each prefix sum occurred.  
This allows constant-time lookup to check whether a subarray summing to `k` ends at the current index.

### Steps:
- Traverse the array while maintaining the prefix sum.
- For each prefix sum, store the index if it’s not already in the map.
- If `(prefixSum - k)` exists in the map, update the max length.

---

## Time Complexity

- **O(n)** — We traverse the array once and use constant-time HashMap operations.

## Space Complexity

- **O(n)** — For storing prefix sums in the map.

---

### 📌 Tags: `HashMap`, `Prefix Sum`, `Sliding Window`, `Array`
