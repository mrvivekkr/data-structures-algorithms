# Partition Equal Subset Sum

## Problem Statement
Given an integer array `nums`, return `true` if you can partition the array into two subsets such that the sum of the elements in both subsets is equal, or `false` otherwise.

---

## Example 1:
**Input:**
nums = [1,5,11,5]

**Output:**


true

**Explanation:**
The array can be partitioned as `[1, 5, 5]` and `[11]`.

---

## Example 2:
**Input:**


nums = [1,2,3,5]

**Output:**


false

**Explanation:**
The array cannot be partitioned into equal sum subsets.

---

## Constraints:
- `1 <= nums.length <= 200`
- `1 <= nums[i] <= 1000`

---

## Approach
1. Compute the **total sum** of the array.
2. If the sum is **odd**, return `false` (cannot divide into two equal subsets).
3. Target becomes `totalSum / 2` → we need to check if such a subset exists.
4. Solve using:
    - **Recursive approach** (exponential, not efficient).
    - **Dynamic Programming approach**:
        - Use a `dp[i][j]` table where `i` represents number of elements considered and `j` represents sum.
        - Transition:  
          `dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]`
        - Final answer is `dp[n][target]`.

Time Complexity: **O(n * target)**  
Space Complexity: **O(n * target)**

---

### 📌 Tags: `Dynamic Programming`, `Subset Sum`, `Recursion`, `Medium`
