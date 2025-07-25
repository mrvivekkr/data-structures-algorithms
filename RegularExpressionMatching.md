# Regular Expression Matching

**Platform**: LeetCode  
**Difficulty**: Hard  
**Link**: [https://leetcode.com/problems/regular-expression-matching/](https://leetcode.com/problems/regular-expression-matching/)

---

## 🧠 Problem Statement

Given an input string `s` and a pattern `p`, implement regular expression matching with support for:

- `.` Matches **any single character**.
- `*` Matches **zero or more of the preceding element**.

The matching should cover the **entire input string**.

---

## 🧪 Examples

### Example 1
**Input:**  
s = `"aa"`, p = `"a"`  
**Output:** `false`  
**Explanation:** "a" does not match the entire string "aa".

### Example 2
**Input:**  
s = `"aa"`, p = `"a*"`  
**Output:** `true`  
**Explanation:** '*' means zero or more of the preceding element, so "a*" can match "aa".

### Example 3
**Input:**  
s = `"ab"`, p = `".*"`  
**Output:** `true`  
**Explanation:** ".*" can match any string.

---

## 💡 Approach

We use **Recursion** to explore whether the string matches the pattern from a given index.

### Rules:
- If the current character in the pattern is followed by `*`, we can:
    - Skip the `*` (zero occurrence)
    - Or, if the current character matches, consume a character from the string and try again
- If not followed by `*`, we must match the current character (or `.`) and move both pointers forward.

### Steps:
1. If pattern is exhausted, check if string is also fully matched.
2. Check current character match.
3. If next character is `*`, branch:
    - Skip (`j+2`)
    - Or consume one match (`i+1`)
4. Else just proceed to next characters if current matches.

---

## ✅ Time Complexity

- **O(2^(m+n))** in the worst case due to branching at each `*`.
- Can be optimized with **memoization** to **O(m × n)**.

## ✅ Space Complexity

- **O(m × n)** due to recursion stack or memoization table, where `m` = length of `s`, `n` = length of `p`.

---

## 📌 Tags

`Dynamic Programming` `Recursion` `String Matching` `Backtracking` `Hard` `LeetCode-Top` `Pattern Matching`

