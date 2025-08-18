# Median of Two Sorted Arrays

## Problem Statement
You are given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively. Return the median of the two sorted arrays. The overall run time complexity should be `O(log (m+n))`.

### Example 1:
**Input:**  
nums1 = [1,3], nums2 = [2]  
**Output:** 2.0

### Example 2:
**Input:**  
nums1 = [1,2], nums2 = [3,4]  
**Output:** 2.5

---

## Approach

The problem is a classic **binary search partition problem**. The key idea is to partition both arrays in such a way that:

- Left partition contains the same number of elements as the right partition (or one extra in case of odd total length).
- All elements in the left partition are less than or equal to all elements in the right partition.

Steps:
1. Always apply binary search on the smaller array to minimize complexity.
2. Let `mid1` represent the cut position in the first array and `mid2` in the second.
3. Check partition validity:
    - If `maxLeft1 <= minRight2` and `maxLeft2 <= minRight1`, then you have found the correct partition.
    - If not, adjust `low` and `high` accordingly.
4. Once the correct partition is found:
    - If total length is even: median = average of `max(maxLeft1, maxLeft2)` and `min(minRight1, minRight2)`.
    - If odd: median = `max(maxLeft1, maxLeft2)`.

This ensures **O(log(min(m,n)))** time complexity.

---

### 📌 Tags: `Binary Search`, `Array`, `Divide and Conquer`
