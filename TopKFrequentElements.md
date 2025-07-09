# Top K Frequent Elements

**Platform**: LeetCode  
**Difficulty**: Medium  
**Link**: [https://leetcode.com/problems/top-k-frequent-elements/](https://leetcode.com/problems/top-k-frequent-elements/)

---

### 🧠 Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

The output can be in **any order**.

---

### 🧪 Examples

#### Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

#### Example 2:
Input: nums = [1], k = 1
Output: [1]


---

### 💡 Approach

1. Use a **HashMap** to count the frequency of each element.
2. Use a **PriorityQueue (Max Heap)** to store the elements sorted by frequency.
3. Poll the top `k` elements from the heap.

---

### ✅ Time Complexity

- **O(n log k)** — where `n` is the number of elements in `nums`
- Building frequency map: O(n)
- Building the heap: O(n log n)
- Polling top k: O(k log n)

### ✅ Space Complexity

- O(n) for frequency map and heap

---

### 📌 Tags: `HashMap`, `Heap`, `PriorityQueue`, `Top-K`, `Frequency`

