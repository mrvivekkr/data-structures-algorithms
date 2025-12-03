# Wildcard Matching

**Problem:**  
Given an input string `s` and a pattern `p`, implement wildcard pattern matching with support for `?` and `*` where:
- `?` matches any single character.
- `*` matches any sequence of characters (including empty).  
  The matching must cover the **entire** input string (not partial). [web:1]

---

## Example

**Input:**  
`s = "adceb"`, `p = "*a*b"`  
**Output:** `true`

**Input:**  
`s = "acdcb"`, `p = "a*c?b"`  
**Output:** `false`

---

## Approach

**Bottom-up Dynamic Programming** `dp[i][j]` = true if `s[0..i-1]` matches `p[0..j-1]`:

1. **Base**: `dp[0][0] = true`, leading `*`s match empty string
2. **`*`**: `dp[i][j] = dp[i][j-1] || dp[i-1][j]` (empty or one+ chars)
3. **Match**: `dp[i][j] = dp[i-1][j-1]` if chars match or `p[j-1] == '?'`

---

## Complexity Analysis

- **Time Complexity:** \(O(m \times n)\) where \(m = |s|\), \(n = |p|\)
- **Space Complexity:** \(O(m \times n)\) for DP table

---

## Code Implementation

See [WildcardMatching.java](WildcardMatching.java) for the full implementation.

### 📌 Tags: `Dynamic Programming`, `String Matching`, `Wildcard`, `LeetCode Hard`
