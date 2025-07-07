# Longest Substring Without Repeating Characters

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/longest-substring-without-repeating-characters/](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

---

### 🧠 Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

---

### 🧪 Examples:

#### Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.


#### Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1


#### Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.


---

### 💡 Approach

We use the **sliding window technique** and a **HashMap** to track the last seen index of characters.

- Move the window start forward when a duplicate is found
- At each step, update the max length of the current valid window

---

### ✅ Time Complexity: O(n)
Each character is visited at most twice.

### ✅ Space Complexity: O(min(n, m))
Where `m` is the size of the character set (e.g., 26 for lowercase English letters).

---

### 📌 Tags: `Sliding Window`, `HashMap`, `Strings`


