# Subarray Sum Equals K

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/subarray-sum-equals-k](https://leetcode.com/problems/subarray-sum-equals-k)

---

### 🧠 Problem Statement

Given an array of integers `nums` and an integer `k`, return the **total number of continuous subarrays** whose sum equals `k`.

A **subarray** is a contiguous, non-empty sequence of elements within an array.

---

### 🧪 Examples

#### Example 1
**Input:**  
nums = [1, 1, 1], k = 2  
**Output:** 2  
**Explanation:**  
Subarrays [1,1] (starting at index 0 and 1) both sum to 2.

#### Example 2
**Input:**  
nums = [1, 2, 3], k = 3  
**Output:** 2  
**Explanation:**  
Subarrays [1,2] and [3] both sum to 3.

#### Example 3
**Input:**  
nums = [-1, -1, 1], k = 0  
**Output:** 1

---

### 💡 Approach

We use **Prefix Sum with HashMap** to count the number of subarrays that sum to `k` in **O(n)** time.

#### Idea:
- Keep a running prefix sum.
- Store frequency of each prefix sum in a hashmap.
- For each element, check if `runningSum - k` exists in the map:
    - If yes, add the frequency to the count.
- Always update the map with the current prefix sum.

---

### ✅ Time Complexity

- **O(n)** – We iterate over the array once.

### ✅ Space Complexity

- **O(n)** – In the worst case, we store up to `n` prefix sums.

---

### 📌 Tags

`Prefix Sum` `HashMap` `Sliding Window` `Subarray` `Medium`
