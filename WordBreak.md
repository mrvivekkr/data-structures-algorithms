# Word Break

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/word-break/](https://leetcode.com/problems/word-break/)

---

### 🧠 Problem Statement

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

You may reuse the same word in the dictionary multiple times.

---

### 🧪 Examples

#### Example 1:
**Input:**  
s = "leetcode", wordDict = ["leet","code"]  
**Output:** true  
**Explanation:** "leetcode" can be segmented as "leet code".

#### Example 2:
**Input:**  
s = "applepenapple", wordDict = ["apple","pen"]  
**Output:** true  
**Explanation:** "applepenapple" can be segmented as "apple pen apple".

#### Example 3:
**Input:**  
s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]  
**Output:** false

---

### 💡 Approach

We use **Dynamic Programming (Bottom-Up)** to solve this.

Let `dp[i]` be `true` if the substring `s[0..i-1]` can be segmented using words in `wordDict`.

### Steps:
- Initialize `dp[0] = true` (empty string is always valid).
- Loop `i = 1` to `n`:
    - For each `j = 0` to `i`:
        - If `dp[j]` is true and `s[j..i-1]` is in the dictionary → set `dp[i] = true`.

Return `dp[n]` which indicates if the entire string can be segmented.

---

### ✅ Time Complexity

- **O(n²)** — where `n` is the length of the input string.  
  For each `i`, we loop over all `j < i` and perform substring lookup.

### ✅ Space Complexity

- **O(n)** — for the DP array.

---

### 📌 Tags

`Dynamic Programming` `String` `Trie` `Word Dictionary` `Bottom-Up DP`

---