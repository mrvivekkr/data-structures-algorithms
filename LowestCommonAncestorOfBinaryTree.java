/**
 * Problem: Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes.
 */

public class LowestCommonAncestorOfBinaryTree {

    /**
     * Recursive method to find the Lowest Common Ancestor.
     * @param root Root of the current subtree
     * @param p First node
     * @param q Second node
     * @return LCA of nodes p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if current node is null or matches one of the target nodes
        if (root == null || root.val == p.val || root.val == q.val)
            return root;

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both calls returned non-null, current node is LCA
        if (left != null && right != null)
            return root;

        // Otherwise, return the non-null result
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        LowestCommonAncestorOfBinaryTree solution = new LowestCommonAncestorOfBinaryTree();

        // Test case 1: LCA of 5 and 1 is 3
        TreeNode res = solution.lowestCommonAncestor(root, root.left, root.right);
        System.out.println("LCA of 5 and 1: " + res.val);

        // Test case 2: LCA of 5 and 4 is 5
        res = solution.lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println("LCA of 5 and 4: " + res.val);
    }
}

// TreeNode class definition
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {}
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
