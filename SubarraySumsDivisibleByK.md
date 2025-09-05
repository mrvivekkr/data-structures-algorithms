# Subarray Sums Divisible by K

## 📘 Problem Statement
Given an integer array `nums` and an integer `k`, return the number of **non-empty subarrays** whose sum is divisible by `k`.

A **subarray** is a contiguous part of an array.

---

## ✅ Example
### Example 1:
**Input:**  
`nums = [4,5,0,-2,-3,1], k = 5`

**Output:**  
`7`

**Explanation:**  
The 7 subarrays that have a sum divisible by 5 are:
- `[4,5,0,-2,-3,1]`
- `[5]`
- `[5,0]`
- `[5,0,-2,-3]`
- `[0]`
- `[0,-2,-3]`
- `[-2,-3,1]`

---

### Example 2:
**Input:**  
`nums = [5], k = 9`

**Output:**  
`0`

---

## 💡 Approach & Complexity
We use the **prefix sum + hashmap (remainder frequency)** technique:

1. Maintain a running prefix sum.
2. For each prefix, compute the remainder `rem = ((sum % k) + k) % k` (ensures non-negative remainder).
3. If the same remainder has appeared before, it means there are subarrays ending at the current index whose sum is divisible by `k`.
4. Keep a frequency map of remainders and add counts accordingly.

### ⏱️ Complexity Analysis
- **Time Complexity:** `O(n)` (single pass over the array)
- **Space Complexity:** `O(k)` (map stores at most `k` remainders)

---

📌 Tags: Prefix Sum, HashMap, Math, Array
