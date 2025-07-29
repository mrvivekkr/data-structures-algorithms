                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           # Maximum Sum Circular Subarray

## Problem

Given a **circular integer array** `nums` of length `n`, return the **maximum possible sum** of a non-empty subarray of `nums`.

A circular array means the end of the array connects to the beginning. You **may not wrap around more than once**.

---

## Examples

### Example 1
**Input:**  
`nums = [1,-2,3,-2]`  
**Output:** `3`  
**Explanation:** Subarray `[3]` has maximum sum 3.

---

### Example 2
**Input:**  
`nums = [5,-3,5]`  
**Output:** `10`  
**Explanation:** Subarray `[5,5]` gives maximum circular sum of 10.

---

### Example 3
**Input:**  
`nums = [-3,-2,-3]`  
**Output:** `-2`  
**Explanation:** Best choice is the single element `-2`.

---

## Approach

We use a combination of:

- **Kadane’s algorithm** to compute `maxSubarraySum` (non-circular).
- **Modified Kadane’s** to compute `minSubarraySum`.
- **Total array sum** to calculate circular max: `totalSum - minSum`.

If the entire array is negative, we just return the non-circular `maxSubarraySum`.

---

## Time Complexity

- **O(n)** — single pass through the array

## Space Complexity

- **O(1)** — constant space

---

### 📌 Tags: `Kadane`, `Array`, `Dynamic Programming`, `Sliding Window`, `Greedy`
                                    