import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Zigzag Level Order Traversal.
 *
 * Given the root of a binary tree, return the zigzag level order traversal
 * of its nodes' values. That is, the first level is left-to-right, the next
 * is right-to-left, and so on, alternating each level.
 */
public class ZigZagLevelOrderTraversal {

    /**
     * Returns the zigzag level order traversal of the given binary tree.
     *
     * Time complexity:  O(n), where n is the number of nodes in the tree,
     *                   since each node is pushed and popped at most once
     *                   from a stack.[web:1][web:20]
     * Space complexity: O(n) in the worst case for the stacks and result
     *                   list (for a skewed tree).[web:1][web:20]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // Edge case: empty tree.
        if (root == null) {
            return res;
        }

        // s1 holds nodes of the current level being processed.
        // s2 holds nodes of the next level.
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {

            // Process current level left-to-right using s1,
            // and push children into s2 in left-to-right order.
            List<Integer> level = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                level.add(curr.val);

                if (curr.left != null) {
                    s2.push(curr.left);
                }
                if (curr.right != null) {
                    s2.push(curr.right);
                }
            }
            if (!level.isEmpty()) {
                res.add(level);
            }

            // Process next level right-to-left using s2,
            // and push children into s1 in right-to-left order,
            // so the following iteration becomes left-to-right again.
            level = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode curr = s2.pop();
                level.add(curr.val);

                if (curr.right != null) {
                    s1.push(curr.right);
                }
                if (curr.left != null) {
                    s1.push(curr.left);
                }
            }
            if (!level.isEmpty()) {
                res.add(level);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal solution = new ZigZagLevelOrderTraversal();

        // Example tree:
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = solution.zigzagLevelOrder(root);
        System.out.println(res);
    }
}
