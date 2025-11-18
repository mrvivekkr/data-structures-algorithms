# Generate Parentheses Problem

This repository contains a Java solution to the [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) problem using backtracking.

## Problem Statement

Given *n* pairs of parentheses, generate all combinations of well-formed parentheses.

A valid combination means every opening parenthesis has a corresponding closing parenthesis and the pairs are correctly nested.

## Approach

- Use a recursive backtracking method.
- Track the count of opening and closing parentheses used so far.
- Only add an opening parenthesis if the count is less than *n*.
- Only add a closing parenthesis if it will not unbalance the string (closing count < opening count).
- When the current string length reaches 2 * n, add it to results.

This approach efficiently explores only valid paths and prunes invalid ones early.

## Usage

1. Compile and run `GenerateParentheses.java`.
2. Modify `n` in the `main` method to generate parentheses for different sizes.
3. The program prints all valid combinations of parentheses.

Example Input:
n = 3

Example Output:
["((()))", "(()())", "(())()", "()(())", "()()()"]

## Tags

`Backtracking` `Recursion` `String` `Medium` `LeetCode`
