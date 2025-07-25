# Rotting Oranges

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/rotting-oranges](https://leetcode.com/problems/rotting-oranges)

---

## 🧠 Problem

You are given an `m x n` grid where each cell can have one of three values:

- `0` → empty cell
- `1` → fresh orange
- `2` → rotten orange

Each minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.

Return the **minimum number of minutes** that must elapse until no cell has a fresh orange.  
If this is **impossible**, return `-1`.

---

## 🧪 Examples

### Example 1
**Input:** `grid = [[2,1,1],[1,1,0],[0,1,1]]`  
**Output:** `4`

### Example 2
**Input:** `grid = [[2,1,1],[0,1,1],[1,0,1]]`  
**Output:** `-1`

### Example 3
**Input:** `grid = [[0,2]]`  
**Output:** `0`

---

## 💡 Approach

We use **Breadth-First Search (BFS)** to simulate rotting over time:

- Start by adding all initially rotten oranges to a queue.
- At each level (minute), process the current size of the queue.
- For each rotten orange, rot its 4-directionally adjacent fresh oranges and add them to the queue.
- Continue until all reachable oranges are rotten.

If any fresh orange remains after BFS, return `-1`. Otherwise, return the time (level - 1).

---

## ✅ Time Complexity: **O(m × n)**
We visit each cell at most once.

## ✅ Space Complexity: **O(m × n)**
Queue stores positions of oranges; worst case all are rotten.

---

## 🔖 Tags

`BFS` `Matrix` `Queue` `Simulation` `Grid Traversal`
