package ca.bytetube._00_leetcode._04_tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
 *
 * @author dal
 */
public class CheckCompletenessOfBinary {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isLeaf && !isLeafNode(node)) return false;
            //1.If node.left!=null && node.right!=null,add node.left and node.right to the queue
            if (hasTwoChildren(node)) {
                queue.offer(node.left);
                queue.offer(node.right);
            }

            //2.If node.left==null && node.right!=null，return false
            else if (node.left == null && node.right != null) return false;

                //3.If node.left!=null && node.right==null,Then the nodes traversed later should all be leaf nodes
            else if (node.left != null && node.right == null) {
                queue.offer(node.left);
                isLeaf = true;

            }
            //4.node.left==null && node.right==null Then the nodes traversed later should all be leaf nodes
            else {
                isLeaf = true;
            }

        }
        return true;
    }

    private boolean hasTwoChildren(TreeNode node) {
        return node.left != null && node.right != null;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
