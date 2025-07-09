# Group Anagrams

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/group-anagrams/](https://leetcode.com/problems/group-anagrams/)

---

### 🧠 Problem Statement

Given an array of strings `strs`, group the anagrams together.  
Anagrams are strings made by rearranging the letters of another string.

Return the answer in **any order**.

---

### 🧪 Examples

#### Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["eat","tea","ate"]]

#### Example 2:
Input: strs = [""]
Output: [[""]]

#### Example 3:
Input: strs = ["a"]
Output: [["a"]]

---

### 💡 Approach

We group words that are anagrams by their **character frequency**:

- For each word, build a hash based on the count of each character
- Use this hash as a key in a map
- Group words with the same hash

This avoids sorting and provides better performance.

---

### ✅ Time Complexity: O(N * K)
- N = number of strings
- K = average length of each string

### ✅ Space Complexity: O(N * K)
- For storing the output groups and frequency map

---

### 📌 Tags: `Hashing`, `String`, `Anagram`, `Frequency Array`

