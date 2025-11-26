# Longest Arithmetic Subsequence

## 📌 Problem Statement
Given an array of integers `nums`, return the length of the longest **arithmetic subsequence** within the array.

A subsequence is derived by deleting zero or more elements without changing the order of the remaining elements.  
An arithmetic subsequence is a sequence where the difference between consecutive elements is constant. In other words, for a sequence `seq`, `seq[i + 1] - seq[i]` is the same for all valid `i`.

---

## 🔹 Examples

### Example 1
**Input:**  
nums = [3, 6, 9, 12]  
**Output:**  
4  
**Explanation:**  
The entire array forms the arithmetic subsequence with a common difference of 3: `[3, 6, 9, 12]`.

---

### Example 2
**Input:**  
nums = [9, 4, 7, 2, 10]  
**Output:**  
3  
**Explanation:**  
One of the longest arithmetic subsequences is `[4, 7, 10]` with difference 3.

---

### Example 3
**Input:**  
nums = [20, 1, 15, 3, 10, 5, 8]  
**Output:**  
4  
**Explanation:**  
The longest arithmetic subsequence is `[20, 15, 10, 5]` with difference -5.

---

## 💡 Approach
We use **dynamic programming with hashmaps** to track arithmetic subsequences:

- Define `dp` as an array of hashmaps: each `dp[i]` stores mappings from difference `diff` to the length of the longest arithmetic subsequence ending at index `i` with difference `diff`.
- Iterate over each pair of indices `(j, i)` with `j < i`, and compute the difference:
  \[
  diff = nums[i] - nums[j]
  \]
- Update `dp[i][diff]` by extending the subsequence ending at `j` with the same difference:
  \[
  dp[i][diff] = dp[j].getOrDefault(diff, 1) + 1
  \]
- Track the maximum length among all `dp[i][diff]`.

This ensures we capture all subsequences defined by their end element and constant difference efficiently.

---

## ⏱️ Complexity Analysis
- **Time Complexity:** \(O(n^2)\) where \(n\) is the length of `nums`, because each pair of indices is processed once.
- **Space Complexity:** \(O(n \times d)\) where \(d\) is the number of unique differences (bounded by number range and \(n\)) due to storing subsequence lengths in hashmaps.

---

📌 Tags: Dynamic Programming, HashMap, Subsequence, Medium
