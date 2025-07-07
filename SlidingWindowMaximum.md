# Sliding Window Maximum

**Platform**: GeeksForGeeks / LeetCode  
**Difficulty**: Hard  
**Link**: https://leetcode.com/problems/sliding-window-maximum/

---

### 🧠 Problem Statement

You are given an array of integers `nums`, and a sliding window of size `k`.  
Move the window from the left to right side of the array, one step at a time.  
At each step, return the **maximum** value in the current window.

---

### 🔍 Input:
- Integer array `nums[]`
- Integer `k` (window size)

### 🎯 Output:
- Integer array of max values from each window

---

### 🧪 Example:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]


**Explanation:**

| Window Position           | Elements        | Max |
|--------------------------|------------------|-----|
| [1  3  -1] -3  5  3  6  7 |                  | 3   |
| 1 [3  -1  -3] 5  3  6  7  |                  | 3   |
| 1  3 [-1  -3  5] 3  6  7  |                  | 5   |
| 1  3  -1 [-3  5  3] 6  7  |                  | 5   |
| 1  3  -1  -3 [5  3  6] 7  |                  | 6   |
| 1  3  -1  -3  5 [3  6  7] |                  | 7   |

---

#### Example 2:
Input: nums = [1], k = 1
Output: [1]


---

### 💡 Approach

We use a **Deque (Double-ended queue)** to store **indices** of elements.  
Key ideas:
- The deque stores **only useful elements** (potential max candidates).
- At every step:
    1. Remove indices that are out of the current window.
    2. Remove smaller elements from the back (they can’t be max anymore).
    3. Add current index to the back.
    4. The front of the deque always has the max value’s index.

---

### ✅ Time Complexity: O(n)
Each element is added and removed **at most once** from the deque.

### ✅ Space Complexity: O(k)
The deque stores at most `k` elements.

---

### 📌 Tags: `Deque`, `Sliding Window`, `Monotonic Queue`

