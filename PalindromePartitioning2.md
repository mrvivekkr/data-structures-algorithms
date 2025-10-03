# ✂️ Palindrome Partitioning II

## 📘 Problem Statement
Given a string `s`, partition `s` such that every substring of the partition is a **palindrome**.

Return the **minimum cuts** needed for a palindrome partitioning of `s`.

---

## ✅ Example
### Input:
```text
s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] requires 1 cut.
```
## 💡 Approach & Complexity

We explore three approaches:

1. **Recursive (Naive)** – Try all partitions.
    - ❌ **Exponential complexity** → Inefficient for large strings.

2. **Recursive with Memoization** – Store results of subproblems.
    - ⏱️ **Time Complexity:** `O(n^2)`
    - 🛠 **Space Complexity:** `O(n)`

3. **Dynamic Programming (Bottom-Up)** – Most efficient solution.
    - Maintain an array `cuts[i] = min cuts needed for substring s[0..i]`.
    - Check all possible partitions using palindrome checks.
    - ⏱️ **Time Complexity:** `O(n^2)`
    - 🛠 **Space Complexity:** `O(n)`
##

📌 Tags: Dynamic Programming, Palindrome, String, Hard