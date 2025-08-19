# Combination Sum II

**Problem:**  
Given a collection of candidate numbers (`candidates`) and a target number (`target`),
find all unique combinations in candidates where the candidate numbers sum to target.

- Each number in candidates may only be used **once** in the combination.
- The solution set must not contain **duplicate combinations**.

---

## Example

**Input:**  
`candidates = [10,1,2,7,6,1,5], target = 8`

**Output:**  
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]


---

## Approach

1. **Sort the array** to handle duplicates easily.
2. Use **backtracking**:
    - Pick a candidate number.
    - Reduce target by that number.
    - Recurse to the next index.
    - Backtrack after exploring.
3. Skip duplicate numbers during iteration to avoid duplicate combinations.

---

## Complexity Analysis

- **Time Complexity:** `O(2^N)` in worst case (each element can be included or excluded).
- **Space Complexity:** `O(N)` for recursion stack and temporary lists.

---

## Code Implementation

See [CombinationSum2.java](CombinationSum2.java) for the full implementation.

### 📌 Tags: `Backtracking`, `Array`, `Sorting`
