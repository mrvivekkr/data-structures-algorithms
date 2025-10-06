import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Class to merge K sorted linked lists into one sorted linked list.
 */
public class MergeKSortedLists {

    /**
     * Merges an array of sorted linked lists into one sorted linked list.
     *
     * @param lists Array of ListNode representing the heads of the sorted linked lists
     * @return ListNode Head of the merged sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue (min-heap) to store nodes sorted by their value
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val; // Min-heap based on node values
            }
        });

        // Add the head of each non-null input list to the priority queue
        for(ListNode node : lists) {
            if(node != null)
                q.add(node);
        }

        // Dummy node to help easily build the merged linked list
        ListNode mergedList = new ListNode(0);
        ListNode current = mergedList; // Pointer to the last node in the merged list

        // Extract the smallest node from the queue, append it,
        // then add its next node to the queue if it exists
        while (!q.isEmpty()){
            ListNode node = q.poll();
            current.next = node;  // Link the extracted node to merged list
            current = current.next; // Move current pointer

            if(node.next != null)
                q.add(node.next); // Add next node to the queue
        }

        return mergedList.next; // Return head of merged list, skipping dummy
    }

    /**
     * Main method to test mergeKLists with sample input
     */
    public static void main(String[] args){
        // Build sample input linked lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // Array of list heads
        ListNode[] lists = new ListNode[]{list1, list2, list3};

        // Create instance of solution class
        MergeKSortedLists solution = new MergeKSortedLists();

        // Merge the k sorted lists
        ListNode mergedHead = solution.mergeKLists(lists);

        // Print the merged linked list
        printList(mergedHead);
    }

    /**
     * Utility method to print linked list
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Definition for singly-linked list node
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
