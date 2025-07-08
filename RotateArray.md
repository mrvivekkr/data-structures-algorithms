# Rotate Array

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/rotate-array/](https://leetcode.com/problems/rotate-array/)

---

### 🧠 Problem Statement

Given an integer array `nums`, rotate the array to the right by `k` steps.  
`k` is non-negative.

The rotation must be done **in-place**, i.e., without using extra space for another array.

---

### 🧪 Examples

#### Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

**Explanation:**

Rotate 1 step → [7,1,2,3,4,5,6]
Rotate 2 steps → [6,7,1,2,3,4,5]
Rotate 3 steps → [5,6,7,1,2,3,4]


#### Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]

---

### 💡 Approach

We use the **array reversal technique**:

1. Reverse the entire array
2. Reverse the first `k` elements
3. Reverse the rest of the array

This effectively rotates the array in-place.

---

### ✅ Time Complexity: O(n)
Each element is swapped at most once.

### ✅ Space Complexity: O(1)
Only constant extra space used.

---

### 📌 Tags: `Array`, `Two Pointers`, `In-Place`, `Reversal`
