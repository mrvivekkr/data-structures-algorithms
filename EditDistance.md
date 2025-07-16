# Edit Distance

## Problem

Given two strings `word1` and `word2`, return the **minimum number of operations** required to convert `word1` to `word2`.

You may perform the following operations on a word:

- Insert a character
- Delete a character
- Replace a character

---

## Examples

### Example 1

**Input:**  
word1 = "horse", word2 = "ros"  
**Output:** 3  
**Explanation:**
- horse → rorse (replace 'h' with 'r')
- rorse → rose (remove 'r')
- rose → ros (remove 'e')

### Example 2

**Input:**  
word1 = "intention", word2 = "execution"  
**Output:** 5

---

## Approach

We use **Dynamic Programming (Bottom-Up)** to compute the minimum edit distance.

Let `dp[i][j]` represent the **minimum number of operations** required to convert the first `i` characters of `word1` to the first `j` characters of `word2`.

### Steps:
- Initialize `dp[0][j] = j` and `dp[i][0] = i` as base cases.
- For each character pair:
    - If characters match, `dp[i][j] = dp[i-1][j-1]`.
    - Else, we take the minimum of:
        - Insert → `dp[i][j-1]`
        - Delete → `dp[i-1][j]`
        - Replace → `dp[i-1][j-1]`
      
        and add 1.

---

## Time Complexity

- **O(m × n)**, where `m` and `n` are lengths of the two input strings.

## Space Complexity

- **O(m × n)** — for the DP table.

---

## Tags

`Dynamic Programming` `2D DP` `String Manipulation` `Edit Distance` `Levenshtein Distance`
