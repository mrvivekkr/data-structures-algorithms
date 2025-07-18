import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, DoublyLinkedNode> map;
    private DoublyLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy head and tail nodes
        head = new DoublyLinkedNode(0, 0);
        tail = new DoublyLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // If key exists, move it to the front and return value
        if (map.containsKey(key)) {
            DoublyLinkedNode target = map.get(key);
            moveToFront(target);
            return target.value;
        }
        return -1; // Key not found
    }

    private void moveToFront(DoublyLinkedNode node) {
        // If already at front, do nothing
        if (head.next == node)
            return;

        // Remove node from current position
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // Move node just after head (most recently used position)
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move to front
            DoublyLinkedNode node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // Add new node to front
            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;

            map.put(key, newNode);
        }

        // Remove least recently used if capacity exceeded
        if (map.size() > capacity) {
            removeNode(tail.prev);
        }
    }

    private void removeNode(DoublyLinkedNode node) {
        // Remove node from DLL
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;

        // Remove from hashmap
        map.remove(node.key);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1)); // Output: 0
        lRUCache.put(3, 3); // Evicts key 2
        System.out.println(lRUCache.get(2)); // Output: -1
        lRUCache.put(4, 4); // Evicts key 1
        System.out.println(lRUCache.get(1)); // Output: -1
        System.out.println(lRUCache.get(3)); // Output: 3
        System.out.println(lRUCache.get(4)); // Output: 4
    }
}

// Node class for doubly linked list
class DoublyLinkedNode {
    int key;
    int value;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;

    public DoublyLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
