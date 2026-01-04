# Maximum Width of Binary Tree

This repository contains a Java solution for the [Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/) problem using level-order traversal with position tracking.

## Problem Statement

Given the `root` of a binary tree, return the **maximum width** of the binary tree.

The **maximum width** of a tree is the maximum width among all levels. The width of each level is defined as the difference between the **rightmost** and **leftmost** node positions at that level, **including all null positions between them**.

**Positioning Rules:**
- Root node is at position `0`
- Left child position = `2 × parent_pos`
- Right child position = `2 × parent_pos + 1`


## Approach

### Level-Order Traversal + Position Tracking (BFS)

1. Use queue storing (TreeNode, position) pairs

2. For each level:

    - leftPos = first node's position
    - Process all nodes, tracking max(rightPos - leftPos + 1)
    - Add children with positions: left=2pos, right=2pos+1 

3. Return global maximum width


**Key Insight:** Progressive width calculation works because rightmost node gives true level width.


## Complexity Analysis

**Time Complexity:** `O(N)` - Visit each node exactly once

**Space Complexity:** `O(W)` - Queue stores at most W nodes where W = maximum width

## Key Implementation Details

- Custom `NodePos` class for (TreeNode, position) pairs
- Progressive `maxWidth` update: `pos - leftPos + 1`
- BFS level processing using `queue.size()`
- Complete binary tree indexing: `left=2*pos`, `right=2*pos+1`

## Tags

`Binary Tree` `BFS` `Level Order` `Queue` `Position Tracking` 
