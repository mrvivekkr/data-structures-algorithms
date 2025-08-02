# Longest Subarray of 1's After Deleting One Element

## Problem

Given a binary array `nums`, you must delete one element from it.  
Return the size of the longest non-empty subarray containing only `1`'s in the resulting array.  
Return `0` if no such subarray exists.

---

## Examples

### Example 1
**Input:** nums = [1,1,0,1]  
**Output:** 3  
**Explanation:** Delete index 2 → [1,1,1] → max length = 3

### Example 2
**Input:** nums = [0,1,1,1,0,1,1,0,1]  
**Output:** 5  
**Explanation:** Delete index 4 → [1,1,1,1,1]

### Example 3
**Input:** nums = [1,1,1]  
**Output:** 2  
**Explanation:** Must delete one element → [1,1]

---

## Approach

- Identify all positions of zeros in the array.
- If there are 0 or 1 zeros, simply return `n - 1` (as we must delete one).
- Otherwise, for each zero, simulate deleting it and compute the maximum length of 1's obtained by merging the left and right segments.
- Return the maximum among all such deletions.

---

## Time Complexity

- **O(n)** — Single pass to identify zero positions and another pass to compute max length.

## Space Complexity

- **O(k)** — Where `k` is the number of zeros in the array (stored in a list).

---

### 📌 Tags: `Sliding Window`, `Greedy`, `Array`, `Prefix Sum`
