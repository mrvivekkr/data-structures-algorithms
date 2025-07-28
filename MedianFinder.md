# Find Median from Data Stream

**Platform**: LeetCode  
**Difficulty**: Hard  
**Link**: [https://leetcode.com/problems/find-median-from-data-stream/](https://leetcode.com/problems/find-median-from-data-stream/)

---

## 🧠 Problem Statement

The median is the middle value in an ordered integer list. If the list size is even, the median is the mean of the two middle values.

Implement the `MedianFinder` class:

- `MedianFinder()` initializes the object.
- `void addNum(int num)` adds the number to the data structure.
- `double findMedian()` returns the current median of all elements added so far.

---

## 🔍 Examples

### Example 1

**Input:**  
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]  
[[], [1], [2], [], [3], []]

**Output:**  
[null, null, null, 1.5, null, 2.0]

---

## 💡 Approach

We use two heaps to maintain the order:

- **Max heap (left side)** to store the smaller half.
- **Min heap (right side)** to store the larger half.

### Key Steps:

1. Add number to `leftMaxHeap`.
2. Move the max element from `leftMaxHeap` to `rightMinHeap`.
3. Balance sizes: If `rightMinHeap` has more elements, move min to `leftMaxHeap`.

This way, the largest of the smaller half and the smallest of the larger half are always accessible in O(1) time, and their balance helps in calculating the median efficiently.

---

## ⏱ Time Complexity

- **addNum:** O(log n) — for heap insertion and balancing
- **findMedian:** O(1) — peek from heap tops

## 💾 Space Complexity

- **O(n)** — storing n elements across both heaps

---

## 🏷 Tags

`Heap` `PriorityQueue` `Median` `DataStream` `Two Heaps`
