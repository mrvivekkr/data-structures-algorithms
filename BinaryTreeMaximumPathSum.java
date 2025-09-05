public class BinaryTreeMaximumPathSum {
    // Variable to track the maximum path sum found so far
    private int pathSum;

    // Main function to compute maximum path sum in the binary tree
    public int maxPathSum(TreeNode root) {
        // Initialize pathSum with the smallest possible integer value
        pathSum = Integer.MIN_VALUE;
        // Call recursive utility function to update pathSum
        maxPathSumUtil(root);
        return pathSum;
    }

    // Recursive helper function that computes the maximum gain from each node
    public int maxPathSumUtil(TreeNode root) {
        if (root == null)
            return 0;

        // Recursively calculate max sum from left and right subtrees
        // Ignore negative sums by taking Math.max(0, …)
        int left = Math.max(0, maxPathSumUtil(root.left));
        int right = Math.max(0, maxPathSumUtil(root.right));

        // Update global pathSum considering the current node
        // as the "highest" node in the path
        pathSum = Math.max(pathSum, root.val + left + right);

        // Return the max sum including the current node and
        // one of its subtrees (either left or right)
        return root.val + Math.max(left, right);
    }

    // Driver code for testing
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

        // Example Tree:
        //       -10
        //       /  \
        //      9    20
        //          /  \
        //         15   7
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Expected Output: 42 (15 + 20 + 7)
        System.out.println(solution.maxPathSum(root));
    }
}
