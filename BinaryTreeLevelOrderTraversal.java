import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Level Order Traversal of a Binary Tree
 *
 * Given the root of a binary tree, return the level order traversal
 * of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Performs level order traversal using a queue (BFS).
     *
     * @param root the root node of the binary tree
     * @return list of levels with node values
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Traverse each level
        while (!queue.isEmpty()) {
            List<Integer> levelElements = new ArrayList<>();
            int levelSize = queue.size();

            // Traverse all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelElements.add(currentNode.val);

                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }

            res.add(levelElements);
        }

        return res;
    }

    public static void main(String[] args) {
        // Constructing binary tree:
        //     3
        //    / \
        //   9  20
        //      / \
        //     15  7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> res = solution.levelOrder(root);
        System.out.println(res); // [[3], [9, 20], [15, 7]]
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
