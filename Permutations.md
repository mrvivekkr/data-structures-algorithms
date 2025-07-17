# Permutations

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/permutations/](https://leetcode.com/problems/permutations/)

---

### 🧠 Problem Statement

Given an array `nums` of distinct integers, return **all possible permutations**.  
You can return the answer in any order.

---

### 🧪 Examples:

#### Example 1:
**Input:** nums = [1,2,3]  
**Output:**  
[
[1,2,3],  
[1,3,2],  
[2,1,3],  
[2,3,1],  
[3,1,2],  
[3,2,1]  
]

#### Example 2:
**Input:** nums = [0,1]  
**Output:** [[0,1], [1,0]]

#### Example 3:
**Input:** nums = [1]  
**Output:** [[1]]

---

### 💡 Approach

We use **Backtracking** to generate all permutations of the array.

### Steps:
- Fix the first element and recursively permute the rest.
- Swap each element from the current index to the end.
- After recursion, backtrack by undoing the swap.

Each recursive call fixes one position and proceeds to fill the rest.

---

### ✅ Time Complexity: O(n × n!)
- There are `n!` permutations.
- Copying each permutation takes O(n) time.

### ✅ Space Complexity: O(n)
- For recursion stack and temporary space.

---

### 📌 Tags:
`Backtracking` `Recursion` `Array` `Permutations` `DFS`

