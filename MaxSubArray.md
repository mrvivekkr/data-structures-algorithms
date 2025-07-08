# Maximum Subarray

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/maximum-subarray/](https://leetcode.com/problems/maximum-subarray/)

---

### 🧠 Problem Statement

Given an integer array `nums`, find the contiguous subarray (containing at least one number)  
which has the **largest sum**, and return its sum.

---

### 🧪 Examples:

#### Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6

#### Example 2:
Input: nums = [1]
Output: 1
Explanation: The only subarray is itself

#### Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: Entire array is the max subarray

---

### 💡 Approach

We use **Kadane's Algorithm** to solve this in **O(n)** time:

- Maintain a running sum.
- If adding the current number reduces the running sum, start fresh from current.
- Track the maximum sum encountered so far.

---

### ✅ Time Complexity: O(n)
We traverse the array only once.

### ✅ Space Complexity: O(1)
Only variables, no extra data structures.

---

### 📌 Tags: `Kadane`, `Array`, `DP`, `Sliding Window`



