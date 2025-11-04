# Triangle Minimum Path Sum Problem

This repository contains a solution for the [Triangle Minimum Path Sum](https://leetcode.com/problems/triangle/) problem using Java.

## Problem Statement

Given a triangle array, return the minimum path sum from top to bottom. At each step, you may move to adjacent numbers on the row below. That is, if you are on index `i` on the current row, you may move to either index `i` or `i + 1` on the next row.

## Approach

- Use a bottom-up dynamic programming approach.
- Initialize a 1D DP array with values from the bottom row of the triangle.
- Iterate from the second-last row up to the top, updating the DP array by choosing the minimum of the two adjacent numbers from the row below plus the current element's value.
- The first element of the DP array will eventually hold the minimum path sum.

## Usage

1. Compile and run `Solution.java`.
2. The solution expects a `List<List<Integer>>` representing the triangle as input.
3. The final returned value is the minimum path sum.

Example:

Input:
int[][] input = {
{2},
{3, 4},
{6, 5, 7},
{4, 1, 8, 3}
};

Output:
11


Explanation: The path 2 → 3 → 5 → 1 gives the minimum sum 11.

## Tags

`Dynamic Programming` `Bottom-Up` `Triangle` `Medium` `Graph`
