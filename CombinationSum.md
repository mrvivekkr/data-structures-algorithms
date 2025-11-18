# Combination Sum — LeetCode 39

## Problem Statement

Given an array of **distinct** positive integers `candidates` and a positive integer `target`, return a list of all **unique combinations** of `candidates` where the numbers sum to `target`.
- Each number may be used **unlimited times** in a combination.
- The order of numbers in each combination does not matter; `[2, 2, 3]` and `[3, 2, 2]` are considered the same, so only one should be included.

---

## Example

**Input:**  
`candidates = [2, 3, 6, 7], target = 7`

**Output:**  
`[[2, 2, 3], [7]]`

---

## Approach

1. Use **backtracking** to explore all possible combinations:
    - Start with the first candidate.
    - Add the current candidate to a temporary list.
    - Recursively continue exploring with the updated target (target - candidate) and the same starting index (allowing reuse).
    - If the target hits zero, record the current combination.
    - If the target goes negative, backtrack.
2. Always start recursion for new candidates from the current index to avoid duplicate combinations.

---

## Complexity Analysis

- **Time Complexity:**  
  The number of unique combinations is constrained under 150 for given inputs, making the backtracking approach feasible.

- **Space Complexity:**  
  Recursion stack depth and storage for results lead to \(O(k)\) space where \(k\) is the size of current combination.

---

## Key Takeaways

- Leverage backtracking to solve combination or subset problems with constraints.
- Control candidate selection in recursion to prevent duplicate results.
- Allow unlimited reuse of candidates by not moving start index ahead when recursing.

---

### 📌 Tags: `Backtracking`, `Combination Sum`, `Recursion`
