# Letter Combinations of a Phone Number

## Problem

Given a string containing digits from `2` to `9` inclusive,  
return all possible letter combinations that the number could represent,  
based on the classic phone number keypad mapping.  
The digit `1` does not map to any letters.

---

## Examples

### Example 1
**Input:**  
digits = "23"  
**Output:** ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]  
**Explanation:**  
Digit '2' maps to ["a", "b", "c"],  
and digit '3' maps to ["d", "e", "f"].  
All combinations are formed by concatenating letters from these sets.

---

### Example 2
**Input:**  
digits = ""  
**Output:** []  
**Explanation:**  
Empty input returns an empty list.

---

### Example 3
**Input:**  
digits = "7"  
**Output:** ["p", "q", "r", "s"]  
**Explanation:**  
Digit '7' maps to four letters.

---

## Approach

We use **Backtracking** (or DFS) to generate all possible letter combinations:

- Create a map from digits to their corresponding letters.
- Use a recursive helper function to build combinations.
- For each digit at index `i`, loop through its possible letters.
- Append a letter to the current combination and recurse to the next digit.
- When the length of the current combination equals the input length,  
  add it to the results list.

This approach explores all possible combinations by depth-first traversal.

---

## Time Complexity

- **O(3^N × 4^M)** where `N` is the count of digits mapping to 3 letters,  
  and `M` is the count of digits mapping to 4 letters (like digits 7 and 9).

---

## Space Complexity

- **O(N)** for the recursion stack and the current combination string,  
  where `N` is the length of the input digit string.

---

## Tags

`Backtracking` `DFS` `Recursion` `String Combinations` `LeetCode`
