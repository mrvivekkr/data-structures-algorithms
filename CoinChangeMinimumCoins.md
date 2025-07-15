# Coin Change - Minimum Coins

## Problem

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.  
If that amount cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

---

## Examples

### Example 1
**Input:**  
coins = [1,2,5], amount = 11  
**Output:** 3  
**Explanation:** 11 = 5 + 5 + 1

### Example 2
**Input:**  
coins = [2], amount = 3  
**Output:** -1

### Example 3
**Input:**  
coins = [1], amount = 0  
**Output:** 0

---

## Approach

We use **Dynamic Programming** to solve this problem.

- Create a `minCoins[]` array of size `amount + 1`, initialized with `Integer.MAX_VALUE`.
- Set `minCoins[0] = 0` as base case (0 coins needed to make amount 0).
- For each coin, iterate through amounts from `coin` to `amount`.
    - If `minCoins[j - coin]` is not `MAX`, update `minCoins[j]` as `min(minCoins[j], 1 + minCoins[j - coin])`.

Return `minCoins[amount]` if it's not `MAX`, else return -1.

---

## Time Complexity

- **O(amount × n)** where `n` is the number of coin denominations.

## Space Complexity

- **O(amount)** — for the DP array.

