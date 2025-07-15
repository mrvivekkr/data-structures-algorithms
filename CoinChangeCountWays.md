# Coin Change - Count Ways

## Problem

Given an integer array `coins[]` representing different denominations and an integer `amount`,  
return the **total number of combinations** that make up that amount.

You may assume that you have an **infinite number of each kind of coin**.

---

## Examples

### Example 1
**Input:**  
coins = [1, 2, 5], amount = 5  
**Output:** 4  
**Explanation:** There are four ways to make 5:
- 5 = 5
- 5 = 2 + 2 + 1
- 5 = 2 + 1 + 1 + 1
- 5 = 1 + 1 + 1 + 1 + 1

### Example 2
**Input:**  
coins = [2], amount = 3  
**Output:** 0

---

## Approach

We use **Dynamic Programming (Bottom-Up)** to count the number of ways to reach a given amount.

Let `dp[i][j]` be the number of ways to make sum `i` using first `j` coins.

### Steps:
- Initialize a 2D array `dp[amount+1][n+1]` with all zeroes.
- Set `dp[0][j] = 1` for all `j` since there's 1 way to make amount `0` (by choosing no coin).
- For each `j` from 1 to number of coins:
    - For each `i` from 1 to amount:
        - `dp[i][j] = dp[i][j-1]` → exclude the coin
        - If `coins[j-1] <= i`, include the coin:
            - `dp[i][j] += dp[i - coins[j-1]][j]`

Return `dp[amount][n]`.

---

## Time Complexity

- **O(amount × n)** where `n` is the number of coin denominations.

## Space Complexity

- **O(amount × n)** — for the DP table.

---

## Tags

`Dynamic Programming` `2D DP` `Unbounded Knapsack` `Combinatorics` `Bottom-Up`