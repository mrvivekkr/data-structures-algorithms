# Longest Subarray With At Most K Frequency (LeetCode 2958)

## Problem

Given an integer array `nums` and an integer `k`, return the **length of the longest good subarray** of `nums`.

A **good subarray** is a subarray where the **frequency of each element** is **less than or equal to k**.

A **subarray** is a contiguous non-empty sequence of elements within an array.

---

## Examples

### Example 1
**Input:** `nums = [1,2,3,1,2,3,1,2]`, `k = 2`  
**Output:** `6`  
**Explanation:** `[1,2,3,1,2,3]` has frequencies {1:2, 2:2, 3:2}, all ≤ 2.

### Example 2
**Input:** `nums = [1,2,1,2,1,2,1,2]`, `k = 1`  
**Output:** `1`  
**Explanation:** No element can repeat, so longest good subarray has length 1.

### Example 3
**Input:** `nums = [5,5,5,5,5,5,5]`, `k = 4`  
**Output:** `4`  
**Explanation:** Maximum 4 consecutive 5s allowed.

---

## Approach

**Sliding Window** with frequency tracking using HashMap:

### Key Insight
- Expand window by moving `end` pointer right
- When `freq[nums[end]] > k`, shrink from `start` until condition satisfied
- **Only shrink when the just-added element violates constraint** (not checking all elements)
- Track `maxLen = end - start + 1` for valid windows

### Steps:
1. Initialize `start = 0`, `freq` HashMap, `maxLen = 0`
2. For each `end` from 0 to `nums.length-1`:
    - Add `nums[end]` to frequency map
    - While `freq[nums[end]] > k`: remove `nums[start++]` from window
    - Update `maxLen = Math.max(maxLen, end - start + 1)`
3. Return `maxLen`

---

## Time Complexity
**O(n)** — Each element is added and removed from window at most once

## Space Complexity
**O(n)** — HashMap stores at most `n` unique elements

---

## 📌 Tags
`Sliding Window`, `Two Pointers`, `HashMap`, `Frequency Constraint`, `Array`, `Medium`

## 🔗 LeetCode
[2958. Length of Longest Subarray With at Most K Frequency](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/)
