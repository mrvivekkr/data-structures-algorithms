# Reverse Words in a String

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/reverse-words-in-a-string/](https://leetcode.com/problems/reverse-words-in-a-string/)

---

### 🧠 Problem Statement

Given an input string `s`, reverse the **order of the words**.

A word is defined as a sequence of non-space characters.  
Return a string of the words in reverse order, separated by a single space.

✅ The output should:
- Have no leading or trailing spaces
- Replace multiple spaces between words with a single space

---

### 🧪 Examples

#### Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"


#### Example 2:
Input: s = " hello world "
Output: "world hello"


#### Example 3:
Input: s = "a good example"
Output: "example good a"

---

### 💡 Approach

1. Use `trim()` to remove leading and trailing spaces
2. Use `split("\\s+")` to break the string into words, ignoring multiple spaces
3. Traverse the words from the end and append them to a `StringBuilder`

---

### ✅ Time Complexity: O(n)
Where `n` is the length of the string

### ✅ Space Complexity: O(n)
For storing the split words and building the result

---

### 📌 Tags: `String`, `Two Pointers`, `Split`, `Trim`
