# Trapping Rain Water

## Problem

Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

---

## Examples

### Example 1

**Input:**  
`height = [0,1,0,2,1,0,1,3,2,1,2,1]`  
**Output:** `6`  
**Explanation:** Water is trapped between the bars forming 6 units total.

### Example 2

**Input:**  
`height = [4,2,0,3,2,5]`  
**Output:** `9`  
**Explanation:** Water is trapped over multiple valleys.

---

## Approach

We precompute two arrays:

- `leftMax[i]`: Maximum height to the **left** of `i` (including `i`)
- `rightMax[i]`: Maximum height to the **right** of `i` (including `i`)

The water trapped at index `i` is `min(leftMax[i], rightMax[i]) - height[i]`.

We sum over all indices to get the total trapped water.

---

## Time Complexity

- **O(n)** – one pass for leftMax, one for rightMax, one for trapped water sum.

## Space Complexity

- **O(n)** – extra space used for `leftMax` and `rightMax`.

---

### 📌 Tags: `Array`, `Two Pointer`, `Prefix Sum`, `Stack`
