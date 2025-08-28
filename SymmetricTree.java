public class SymmetricTree {

    // Main function that checks if a tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // A null tree is symmetric
        if (root == null) return true;
        // Compare left and right subtrees
        return isSymmetricUtil(root.left, root.right);
    }

    // Utility recursive function to check symmetry
    private boolean isSymmetricUtil(TreeNode l, TreeNode r) {
        // If both subtrees are null -> symmetric
        if (l == null && r == null) return true;

        // If only one of them is null -> not symmetric
        if (l == null || r == null) return false;

        // If values don't match -> not symmetric
        if (l.val != r.val) return false;

        // Recursively check:
        //  - left child of left subtree with right child of right subtree
        //  - right child of left subtree with left child of right subtree
        return isSymmetricUtil(l.left, r.right) && isSymmetricUtil(l.right, r.left);
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     2
            / \   / \
           3   4 4   3
         This tree is symmetric
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree solution = new SymmetricTree();
        System.out.println(solution.isSymmetric(root)); // Output: true
    }
}
