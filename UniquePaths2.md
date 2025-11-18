# Unique Paths II Problem

This repository contains a Java solution for the [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) problem using dynamic programming and recursion with memoization.

## Problem Statement

Given an \(m \times n\) grid `obstacleGrid`, a robot is initially located at the top-left corner (cell \((0, 0)\)). The robot aims to reach the bottom-right corner (cell \((m-1, n-1)\)).

- The robot can only move either down or right at any point in time.
- Some cells are marked as obstacles (value `1`) and some as free spaces (value `0`).
- The robot cannot move into or through cells with obstacles.

Return the number of unique paths the robot can take to reach the bottom-right corner without crossing any obstacles.

The problem guarantees the result fits within the range of a 32-bit integer.

## Approach

This solution implements two approaches:

### 1. Recursive Memoization (Top-Down DP)

- Uses recursion to explore paths going down and right.
- Memoization caches results to avoid recomputation.
- Handles base cases for obstacles, boundaries, and destination.

### 2. Iterative Dynamic Programming (Bottom-Up DP)

- Uses a 2D DP array with padding for boundary management.
- Initializes start point based on obstacle presence.
- Fills DP table by summing paths from top and left cells unless blocked by obstacles.
- Returns total paths at the bottom-right corner.

## Usage

1. Compile and run `UniquePaths2.java`.
2. Modify the `obstacleGrid` in `main` method to test different cases.
3. The output prints the number of unique paths avoiding obstacles.

Example input:
int[][] obstacleGrid = {
{0, 0, 0},
{0, 1, 0},
{0, 0, 0}
};

Expected output:
2

## Tags

`Dynamic Programming` `Memoization` `Grid` `Medium` `LeetCode`
