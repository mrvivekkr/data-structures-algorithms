# Palindrome Partitioning

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/palindrome-partitioning](https://leetcode.com/problems/palindrome-partitioning)

---

## 🧠 Problem Statement

Given a string `s`, partition `s` such that every substring of the partition is a **palindrome**.  
Return all possible palindrome partitioning of `s`.

---

## 🧪 Examples

### Example 1
**Input**:  
`s = "aab"`  
**Output**:  
`[["a","a","b"],["aa","b"]]`

---

### Example 2
**Input**:  
`s = "a"`  
**Output**:  
`[["a"]]`

---

## 💡 Approach

We use **Backtracking** (DFS) to try every possible substring partition:

### Steps:
1. Start from index 0.
2. At every step, check all substrings from current index to end:
    - If the substring is a palindrome, add it to the path.
    - Recur for the remaining string starting from the next index.
3. If the start index reaches the end of the string, add the current path to the result.
4. Backtrack to try other substrings.

---

## ✅ Time Complexity

- **O(2ⁿ × n)** — where `n` is the length of the string.
    - At each index, we decide to cut or not → 2ⁿ possibilities.
    - Each substring takes up to `O(n)` to copy/check.

---

## ✅ Space Complexity

- **O(n)** — recursion stack and path list.
- **O(2ⁿ × n)** — result list for all possible valid partitions.

---

## 🏷 Tags

`Backtracking` `DFS` `Palindrome` `String Partitioning`
