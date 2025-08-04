# Minimum Insertion Steps to Make a String Palindrome

## ✅ Problem Statement

Given a string `s`. In one step, you can insert any character at any index of the string.

Return the **minimum number of insertions** needed to make `s` a palindrome.

A **palindrome** is a string that reads the same forward and backward.

---

### 🔍 Examples

**Example 1:**
```
Input: s = "zzazz"
Output: 0
Explanation: Already a palindrome.
```

**Example 2:**
```
Input: s = "mbadm"
Output: 2
Explanation: Can be transformed to "mbdadbm" or "mdbabdm".
```

**Example 3:**
```
Input: s = "leetcode"
Output: 5
```

---

## 💡 Approach

We use **Dynamic Programming** to solve this problem efficiently.

Let `dp[i][j]` denote the minimum number of insertions required to make the substring `s[i...j]` a palindrome.

- If `s[i] == s[j]`: No insertion needed at the current ends, so `dp[i][j] = dp[i+1][j-1]`.
- Else: We can insert a character either after `j` or before `i`. So:  
  `dp[i][j] = 1 + min(dp[i+1][j], dp[i][j-1])`

We fill this 2D table bottom-up, considering substrings of increasing length.

---

## 🧠 Complexity

- **Time Complexity:** O(n²)
- **Space Complexity:** O(n²)

Where `n` is the length of the input string.

---

### 📌 Tags: `DP`, `Palindrome`, `String`, `2D DP`, `Hard`
