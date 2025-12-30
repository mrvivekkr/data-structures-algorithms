# Minimum Falling Path Sum (LeetCode 931)

## Problem
Given an `n x n` array of integers `matrix`, return **the minimum sum** of any **falling path** through `matrix`.

A **falling path** starts at any element in the **first row** and chooses the element in the **next row** that is either **directly below** or **diagonally left/right**:
- From `(row, col)` → `(row+1, col-1)`, `(row+1, col)`, or `(row+1, col+1)`

**Example:**
Input:   
{{2, 1, 3},  
{6, 5, 4},   
{7, 8, 9}};  
Output: 13
Path: 1→5→7 (1+5+7=13)


## Approach
**Space-optimized Dynamic Programming** - Modify input matrix **in-place**:

1. **DP State**: `matrix[r][c]` = minimum path sum **to reach** cell `(r,c)`
2. **Transition**: `matrix[r][c] += min(left-diagonal, straight, right-diagonal)` from row `r-1`
3. **Boundaries**: Use `Integer.MAX_VALUE` for invalid positions (edges)
4. **Answer**: `min(matrix[n-1][*])` - minimum in final row


## Complexity
- **Time Complexity**: \(O(n^2)\) - Visit each cell exactly once
- **Space Complexity**: \(O(1)\) - **In-place modification** (interview favorite!)

📌 **Tags**: Dynamic Programming, Matrix DP, Space Optimization, Pathfinding
