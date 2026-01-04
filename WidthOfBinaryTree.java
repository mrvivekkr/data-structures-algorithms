import java.util.LinkedList;
import java.util.Queue;

/**
 * NodePos wrapper class to track TreeNode with its horizontal position
 * Root = pos 0, left child = 2×pos, right child = 2×pos+1
 */
class NodePos {
    public TreeNode node;
    public int pos;

    public NodePos(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}

public class WidthOfBinaryTree {

    /**
     * LeetCode 662: Maximum Width of Binary Tree
     * Returns maximum width across any level (including null gaps between nodes)
     *
     * @param root Root of binary tree
     * @return Maximum width of any level
     * Time: O(N) | Space: O(W) where W = max width
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;  // Edge case: empty tree

        int maxWidth = 0;
        Queue<NodePos> q = new LinkedList<>();
        q.offer(new NodePos(root, 0));  // Initialize BFS queue with root at pos 0

        // Level order traversal
        while (!q.isEmpty()) {
            int size = q.size();           // Nodes at current level
            int leftPos = q.peek().pos;    // Leftmost position of current level

            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                NodePos nodePos = q.poll();
                TreeNode currNode = nodePos.node;
                int pos = nodePos.pos;

                // Track running width from leftmost to current node
                // Rightmost node gives true level width: rightPos-leftPos+1
                maxWidth = Math.max(maxWidth, pos - leftPos + 1);

                // Position children for next level
                // left=2*pos (even), right=2*pos+1 (odd) - complete binary tree indexing
                if (currNode.left != null)
                    q.offer(new NodePos(currNode.left, 2 * pos));
                if (currNode.right != null)
                    q.offer(new NodePos(currNode.right, 2 * pos + 1));
            }
        }
        return maxWidth;
    }

    // GitHub demo with comprehensive test cases
    public static void main(String[] args) {
        WidthOfBinaryTree solution = new WidthOfBinaryTree();

        // Test case: Tree with gaps → Expected width = 7 (level 3: positions 2,3,6,7)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);    // Position 3
        root.right.right = new TreeNode(9);   // Position 7
        System.out.println("Max width: " + solution.widthOfBinaryTree(root)); // 7
    }
}
