# 🪣 Container With Most Water

## 📘 Problem Statement
You are given an integer array `height` of length `n`.  
There are `n` vertical lines drawn such that the two endpoints of the i-th line are `(i, 0)` and `(i, height[i])`.

Find two lines that, together with the x-axis, form a container such that the container contains the **most water**.  
Return the maximum amount of water a container can store.

⚠️ Note: You may not slant the container.

---

## ✅ Example
### Input:
```text
height = [1,8,6,2,5,4,8,3,7]
Output: 49
```
💡 Approach & Complexity

We use the two-pointer technique:

Start with one pointer at the left (l) and the other at the right (r).

Compute the area formed between the two lines.

Update the maximum area found so far.

Move the pointer at the shorter line inward, since the limiting factor is the shorter height.

Repeat until the two pointers meet.

⏱️ Complexity Analysis

Time Complexity: O(n) (each index is visited at most once)

Space Complexity: O(1) (constant extra space)

📌 Tags: Two-Pointers, Greedy, Array, Medium