package ca.bytetube._00_leetcode._04_tree;


/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author dal
 */
public class InvertBinaryTree {

    public TreeNode invertTree1(TreeNode root) {

        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        invertTree(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);

        return root;
    }
}
