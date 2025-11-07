# Combinations

**Problem:**  
Given two integers \(n\) and \(k\), return all possible combinations of \(k\) numbers chosen from the range \([1, n]\). The order of combinations does not matter.

---

## Example

**Input:**  
`n = 4, k = 2`

**Output:**  
[[1, 2],[1, 3],[1, 4],[2, 3],[2, 4],[3, 4]]

---

## Approach

1. Use **backtracking** to generate all subsequences of length \(k\):
    - Start from the first number.
    - Add the current number to the subsequence.
    - Recursively continue with next numbers until the subsequence length reaches \(k\).
    - Backtrack by removing the last added number and try the next candidate.
2. Explore each number from the current index to \(n\) to build all combinations.

---

## Complexity Analysis

- **Time Complexity:** \(O\left(\binom{n}{k} \times k\right)\) because there are \(\binom{n}{k}\) combinations and copying the combination of size \(k\) costs \(O(k)\).
- **Space Complexity:** \(O(k)\) for recursion stack and temporary combination list.

---

## Code Implementation

See [Combinations.java](Combinations.java) for the full implementation.

### 📌 Tags: `Backtracking`, `Combination`, `Recursion`
