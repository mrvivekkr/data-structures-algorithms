# Word Break II Problem

This repository includes a solution for the [Word Break II](https://leetcode.com/problems/word-break-ii/) problem using Java.

## Problem Statement

Given a string `s` and a dictionary `wordDict` containing a list of words, return all possible sentences by segmenting the string `s` such that each word in the sentence exists in `wordDict`. Each sentence is formed by concatenating the words with spaces. All valid sentences must be returned in any order.

## Approach

- The solution uses a backtracking algorithm to explore all potential breaks of string `s`.
- Starting from index 0, for every substring that matches a dictionary word, recursively process the remaining string.
- When the end of the string is reached, add the current sequence of words as a valid sentence to the result.
- After exploration, backtracking removes the last chosen word to try alternative substrings.
- The result is collected as a list of word lists and then transformed to a list of sentence strings by joining words with spaces.

## Usage

1. Compile and run `WordBreak2.java`.
2. The `main` method demonstrates segmenting the string `"catsanddog"` with dictionary `["cat", "cats", "and", "sand", "dog"]`.
3. Expected output:
[cat sand dog, cats and dog]

## Tags

`Backtracking` `Dynamic Programming` `Hard` `String Manipulation`
