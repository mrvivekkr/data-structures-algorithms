# Interleaving String

## Problem Statement
Given strings `s1`, `s2`, and `s3`, determine whether `s3` is formed by an interleaving of `s1` and `s2`.

An **interleaving** of two strings `s` and `t` is a configuration where `s` and `t` are divided into substrings and merged in an alternating fashion, preserving the order of characters from each string.

---

## Example 1:
**Input:**
s1 = "aabcc"
s2 = "dbbca"
s3 = "aadbbcbcac"

makefile
Copy
Edit
**Output:**
true

yaml
Copy
Edit
**Explanation:**  
Split `s1 = "aa" + "bc" + "c"` and `s2 = "dbbc" + "a"`.  
Interleaving gives `"aadbbcbcac"`, which matches `s3`.

---

## Example 2:
**Input:**
s1 = "aabcc"
s2 = "dbbca"
s3 = "aadbbbaccc"

makefile
Copy
Edit
**Output:**
false

yaml
Copy
Edit
**Explanation:**  
No valid interleaving can form `s3`.

---

## Example 3:
**Input:**
s1 = ""
s2 = ""
s3 = ""

makefile
Copy
Edit
**Output:**
true

yaml
Copy
Edit

---

## Constraints:
- `0 <= s1.length, s2.length <= 100`
- `0 <= s3.length <= 200`
- `s1`, `s2`, and `s3` consist of lowercase English letters.

---

## Approach
1. Check if `len(s1) + len(s2) == len(s3)`. If not, return `false`.
2. Use **Dynamic Programming**:
    - Define `dp[i][j]` = whether first `i` characters of `s1` and first `j` characters of `s2` form first `i+j` characters of `s3`.
    - Transition:
        - `dp[i][j] = (s1[i-1] == s3[i+j-1] && dp[i-1][j]) OR (s2[j-1] == s3[i+j-1] && dp[i][j-1])`
3. Return `dp[m][n]`.

Time Complexity: **O(m * n)**  
Space Complexity: **O(m * n)**

---

### 📌 Tags: `Dynamic Programming`, `String`, `Recursion`, `2D DP`, `Medium`