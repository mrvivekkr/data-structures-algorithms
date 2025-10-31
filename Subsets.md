# 78. Subsets

**Level:** Medium  
**Link:** [https://leetcode.com/problems/subsets/](https://leetcode.com/problems/subsets/)

---

## 🧠 Problem

Given an integer array `nums` of **unique elements**, return **all possible subsets** (the power set).  
The solution set **must not** contain duplicate subsets. Return the solution in any order.

---

## 🧪 Examples

**Example 1**  
Input: `nums = [1,2,3]`  
Output:  
[[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]

**Example 2**  
Input: `nums = [0]`  
Output:  
[[], [0]]

---

## 💡 Approach

We use **Backtracking** to recursively explore all subsets.

- Start with an empty subset and at each recursive call, decide to add the current element or not.
- Generate subsets by including elements starting from current index going forwards.
- At each step, add current formed subset to the result.
- Use recursion and backtracking to explore all combinations.

---

## ✅ Time Complexity

- Exponential O(n⋅2n) in worst case due to generating all subsets and copying them.

## ✅ Space Complexity

- Auxiliary space complexity: O(n) O(n) for the recursion stack and temporary subset during backtracking.

- Total space complexity: O(n⋅2n) for storing all possible subsets in the output.

---

### 📌 Tags: `Backtracking`, `Array`, `Power Set`, `Subsets`, `Recursion`
