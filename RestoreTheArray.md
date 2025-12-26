# Restore the Array

LeetCode-style problem:  
A program was supposed to print an array of integers. Instead, all integers were printed **without spaces** and concatenated into a single string `s`.

We know:

- Each original integer was in the range \([1, k]\).
- There are **no leading zeros** in any integer.

Given `s` and `k`, return the **number of possible arrays** that could have produced `s`.  
Return the answer modulo \(10^9 + 7\).

---

## Approach

We want to count the number of ways to split the string `s` into contiguous pieces such that:

- Each piece represents an integer in `[1, k]`.
- No piece starts with `'0'`.

This is a classic “ways to split a string” problem and maps naturally to dynamic programming.

### 1. Recursive intuition

Define a function:

- `f(s)` = number of ways to split the string `s`.

At each call:

1. If `s` is empty: return 1 (we have successfully split the entire original string).
2. If `s` starts with `'0'`: return 0 (invalid, numbers cannot have leading zeros).
3. Otherwise, try all prefixes `s[0..i]`:
    - Convert `s[0..i]` to an integer `val`.
    - If `val > k`, break (longer prefixes will only get larger).
    - Recursively add `f(s[i+1..end])` to the answer.

This directly matches the problem statement but is exponential without memoization.

### 2. Bottom-up DP

To make this efficient, we translate the recursion into DP on indices of the original string.

Let:

- `dp[i]` = number of ways to split the **suffix** `s[i..n-1]`.
- `n = s.length()`.

Then:

- `dp[n] = 1` (empty suffix has one valid split: take nothing).
- The answer is `dp[0]`.

Transition for each position `i` (from right to left):

1. If `s[i] == '0'` ⇒ `dp[i] = 0` (no number can start with zero).
2. Otherwise:
    - Build numbers `val` from `s[i..j]` for increasing `j`.
    - Stop when either:
        - `val > k`, or
        - `j - i + 1` exceeds `digits(k)` (no need to consider longer numbers).
    - For each valid `val` (i.e., `val <= k`), we add `dp[j+1]` to `dp[i]`.

We maintain all counts modulo \(10^9 + 7\).

**Complexity**

- Let \(n = |s|\) and \(L\) = number of digits in `k`.
- Time: \(O(n \cdot L)\) because for each `i` we explore at most `L` positions `j`.
- Space: \(O(n)\) for the `dp` array.

This solution passes all constraints for the LeetCode “Restore The Array” problem.

---

### 📌 Tags
`Dynamic Programming` · `String` · `Recursion`  · `Combinatorics`
