# 0/1 Knapsack Problem

## Problem

Given `n` items, each with a specific weight and value, and a knapsack with a capacity `W`,  
determine the **maximum total value** that can be achieved by placing items in the knapsack such that:

- The total weight of selected items does not exceed `W`.
- Each item can be **included at most once** (0/1 choice).
- Each item is available in **single quantity**.

---

## Examples

### Example 1
**Input:**  
W = 4, val = [1, 2, 3], wt = [4, 5, 1]  
**Output:** 3  
**Explanation:** Pick the third item (weight = 1, value = 3)

---

### Example 2
**Input:**  
W = 3, val = [1, 2, 3], wt = [4, 5, 6]  
**Output:** 0  
**Explanation:** No item fits within the weight capacity.

---

### Example 3
**Input:**  
W = 5, val = [10, 40, 30, 50], wt = [5, 4, 2, 3]  
**Output:** 80  
**Explanation:** Choose item 3 (val=30, wt=2) and item 4 (val=50, wt=3)

---

## Approach

We use **Dynamic Programming (Bottom-Up)** to solve this problem.

Let `dp[j][i]` be the maximum value achievable with a knapsack capacity `j` using the first `i` items.

### Steps:
- Initialize a 2D array `dp[W+1][n+1]` with 0.
- Loop over all items `i = 1 to n`:
    - Loop over capacity `j = 1 to W`:
        - If the current item weight `wt[i-1] <= j`, choose the max of:
            - Include the item: `val[i-1] + dp[j - wt[i-1]][i - 1]`
            - Exclude the item: `dp[j][i - 1]`
        - Else, carry forward `dp[j][i - 1]`

Return `dp[W][n]`.

---

## Time Complexity

- **O(n × W)**  
  Where `n` = number of items, `W` = max weight of the knapsack.

## Space Complexity

- **O(n × W)** — for the 2D DP table

---

## Tags

`Dynamic Programming` `0/1 Knapsack` `DP Table` `Optimization`
