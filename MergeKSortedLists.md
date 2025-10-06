# Merge K Sorted Lists

## Problem
Given an array of `k` sorted linked lists, merge them into one sorted linked list.

## Approach
This solution uses a min-heap (Java `PriorityQueue`) to efficiently merge the sorted lists. The heads of all non-null lists are added into the priority queue. The smallest element is polled and appended to the merged list, and if the polled node has a next node, it is inserted into the queue. This process continues until the queue is empty.

## Complexity
- Time Complexity: \(O(N \log k)\), where \(N\) is the total number of nodes and \(k\) is the number of lists.
- Space Complexity: \(O(k)\) for the priority queue.

## Example
Input: `[[1,4,5],[1,3,4],[2,6]]`  
Output: `1->1->2->3->4->4->5->6`

## Usage
Run the `main` method in `MergeKSortedLists` to see the example run with the sample input.

📌 Tags: Priority Queue, Linked List, Heap, Merge K Sorted Lists, Java