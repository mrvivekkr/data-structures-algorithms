# Word Ladder Problem

This repository includes a solution for the [Word Ladder](https://leetcode.com/problems/word-ladder/) problem using Java.

## Problem Statement

Given two words (`beginWord` and `endWord`) and a dictionary (`wordList`), find the shortest transformation sequence from `beginWord` to `endWord` such that:
- Only one letter can be changed at a time.
- Each transformed word must exist in the word list.
- Return the number of words in the shortest sequence. If no sequence exists, return `0`.

## Approach

- Breadth-First Search (BFS) is used to explore possible sequences.
- For each word, all valid neighboring words that differ by one letter are generated.
- Visited words are tracked to prevent cycles.
- The first time `endWord` is reached, its sequence length is returned.

## Usage

1. Clone the repository.
2. Compile and run `WordLadder.java`.
3. Two sample test cases are provided in the `main` method.

Example:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5

Input: beginWord = "hot", endWord = "dog", wordList = ["hot","dog"]
Output: 0

**Tags:** `Breadth First Search` `Hard` `Graph Theory`