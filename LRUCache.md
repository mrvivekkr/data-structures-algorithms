# LRU Cache

## Problem

Design a data structure that follows the constraints of a **Least Recently Used (LRU)** cache.

Implement the `LRUCache` class:

- `LRUCache(int capacity)` initializes the cache with a positive size `capacity`.
- `int get(int key)` returns the value of the key if the key exists, otherwise returns -1.
- `void put(int key, int value)` updates the value of the key if it exists;  
  otherwise, inserts the key-value pair.  
  If the number of keys exceeds `capacity`, evict the **least recently used** key.

Both operations must run in **O(1)** average time.

---

## Examples

### Example 1
**Input:**  
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]  
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

**Output:**  
[null, null, null, 1, null, -1, null, -1, 3, 4]

**Explanation:**
```java
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache: {1=1}
lRUCache.put(2, 2); // cache: {1=1, 2=2}
lRUCache.get(1);    // returns 1
lRUCache.put(3, 3); // evicts key 2 → cache: {1=1, 3=3}
lRUCache.get(2);    // returns -1
lRUCache.put(4, 4); // evicts key 1 → cache: {3=3, 4=4}
lRUCache.get(1);    // returns -1
lRUCache.get(3);    // returns 3
lRUCache.get(4);    // returns 4
```

---

## Approach

We use a combination of a **HashMap** and a **Doubly Linked List** to achieve **O(1)** time complexity.

- The HashMap maps keys to their corresponding nodes in the linked list.
- The Doubly Linked List maintains the order of access, with:
    - Most Recently Used (MRU) nodes at the **front**.
    - Least Recently Used (LRU) nodes at the **back**.

### Steps:
- When a key is accessed via `get()`, move the corresponding node to the front.
- When inserting with `put()`:
    - If the key exists: update the value and move to front.
    - If not: insert new node at front.
    - If capacity exceeds: remove the node at the end (LRU) and delete from map.

---

## Time Complexity

- **O(1)** for both `get()` and `put()` using HashMap + Doubly Linked List.

## Space Complexity

- **O(capacity)** — for storing up to `capacity` nodes and keys.

---

## Tags

`HashMap` `Doubly Linked List` `Design` `LRU` `Cache` `O(1)` `Data Structures`
