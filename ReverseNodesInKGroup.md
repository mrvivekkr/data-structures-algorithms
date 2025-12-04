# Reverse Nodes in k-Group

**Platform**: LeetCode  
**Difficulty**: Hard  
**Link**: https://leetcode.com/problems/reverse-nodes-in-k-group/

---

### 🧠 Problem Statement

Given the head of a singly linked list, reverse the nodes of the list **in groups of size `k`**, and return the modified list.

A group should be reversed **only if it contains exactly `k` nodes**.  
If fewer than `k` nodes remain at the end, they must stay in their original order.

⚠️ **Important Constraints**:
- You cannot modify node values — only pointers.
- `1 ≤ k ≤ length of the list`
- The solution should run in **O(n)** time.

---

### 🧪 Examples

#### Example 1:
Input:  
`head = [1,2,3,4,5], k = 3`  
Output:  
`[3,2,1,4,5]`

#### Example 2:
Input:  
`head = [1,2,3,4,5], k = 2`  
Output:  
`[2,1,4,3,5]`

#### Example 3:
Input:  
`head = [1], k = 1`  
Output:  
`[1]`

---

### 💡 Approach

This problem is solved by processing the list **one group of size `k` at a time**.

**Steps:**
1. Traverse forward to confirm that a group of **k nodes exists**.
2. If not enough nodes remain, return the list unchanged.
3. Otherwise:
    - Detach the first `k` nodes.
    - Reverse this block.
    - Recursively process the rest of the list.
    - Attach the reversed block in front of the processed remainder.
4. Return the new head of the final list.

This recursive approach naturally handles:
- Reversing each block independently
- Connecting reversed blocks correctly
- Leaving leftover nodes untouched

---

### ⏱️ Time Complexity
**O(n)** — Each node is processed a constant number of times.

### 📦 Space Complexity
**O(n/k)** due to recursion depth (worst case O(n)).

---

### 📌 Tags
`Linked List` · `Recursion` · `Two Pointers` · `Reversal` · `Divide and Conquer`
