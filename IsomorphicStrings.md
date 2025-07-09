# Isomorphic Strings

**Platform**: LeetCode  
**Difficulty**: Easy  
**Link**: [https://leetcode.com/problems/isomorphic-strings/](https://leetcode.com/problems/isomorphic-strings/)

---

### 🧠 Problem Statement

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

- All occurrences of a character must be replaced with another character.
- The mapping must preserve the order.
- No two characters may map to the same character, but a character may map to itself.

---

### 🧪 Examples

#### Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation: e -> a, g -> d

#### Example 2:

Input: s = "foo", t = "bar"
Output: false
Explanation: o needs to map to both a and r, which is not allowed.

#### Example 3:

Input: s = "paper", t = "title"
Output: true
Explanation: p -> t, a -> i, e -> l, r -> e


---

### 💡 Approach

Use **two hash maps**:

- `mapST`: character mapping from s → t
- `mapTS`: character mapping from t → s

At each character index, ensure that:
- The current character from `s` maps to the correct one in `t`
- The reverse mapping is also consistent

If at any index the mapping breaks, return `false`.

---

### ✅ Time Complexity

- **O(n)** where `n` is the length of the strings.

### ✅ Space Complexity

- **O(1)** because the alphabet size is fixed (26 lowercase letters).

---

### 📌 Tags: `HashMap`, `String`, `One-to-One Mapping`



