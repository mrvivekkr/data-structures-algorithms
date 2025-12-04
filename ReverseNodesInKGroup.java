/**
 * LeetCode 25 - Reverse Nodes in k-Group
 *
 * Approach:
 *  - Recursively process the list in blocks of size k.
 *  - For each block:
 *      1. Check if there are at least k nodes.
 *      2. If not, return head as-is (no more reversals).
 *      3. If yes:
 *          - Detach the block of k nodes.
 *          - Reverse that block.
 *          - Recursively process the remaining list.
 *          - Append the reversed block to the result of the recursive call.
 *
 * Time Complexity:  O(n)   (each node is visited a constant number of times)
 * Space Complexity: O(n/k) (recursion depth; worst case O(n))
 */
public class ReverseNodesInKGroup {

    /**
     * Main entry point: reverse nodes of the list in groups of size k.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            // Nothing to reverse for empty list or k = 1
            return head;
        }
        return reverseUtil(head, k);
    }

    /**
     * Recursively reverse the list in chunks of size k.
     *
     * @param head start of the current segment
     * @param k    group size to reverse
     * @return new head of the processed list starting from this segment
     */
    private ListNode reverseUtil(ListNode head, int k) {
        // Find the k-th node starting from head
        int count = 1;
        ListNode end = head;

        while (end != null) {
            end = end.next;
            count++;
            if (count == k) {
                break;
            }
        }

        // If we have at least k nodes in this segment
        if (end != null && count == k) {
            // nextList: head of the remaining list after this k-group
            ListNode nextList = end.next;

            // Temporarily terminate the current segment
            end.next = null;

            // Reverse current k-sized block and recursively process the rest
            ListNode reversedBlock = reverseList(head);
            ListNode processedRest = reverseUtil(nextList, k);

            // Append processedRest to the tail of reversedBlock
            return append(reversedBlock, processedRest);
        }

        // Less than k nodes remain, return as-is (no reversal)
        return head;
    }

    /**
     * Append list2 to the end of list1.
     * Assumes list1 is non-null.
     *
     * @param list1 head of the first list
     * @param list2 head of the second list to append
     * @return head of the combined list (same as list1)
     */
    private ListNode append(ListNode list1, ListNode list2) {
        ListNode curr = list1;
        // Move to the tail of list1
        while (curr.next != null) {
            curr = curr.next;
        }
        // Link list2 at the tail
        curr.next = list2;
        return list1;
    }

    /**
     * Iteratively reverse a singly linked list.
     *
     * @param head head of the list to reverse
     * @return new head of the reversed list
     */
    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

        // Example: head = [1,2,3,4,5], k = 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode out = solution.reverseKGroup(head, 3);

        System.out.println("------Printing list-------");
        ListNode curr = out;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}


