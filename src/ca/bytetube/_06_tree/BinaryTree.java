package ca.bytetube._06_tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {
    private Node<E> root;

    public void preOrderTraversal() {
        preOrderTraversal0(root);
    }


    public void preOrderTraversal0(Node<E> node) {
        if (node == null) return;
        System.out.print(node.element + " ");
        preOrderTraversal0(node.left);
        preOrderTraversal0(node.right);
    }

    //有右先压右，有左再压左
    public void preOrderTraversal(Node<E> node) {
        if (node == null) return;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            System.out.print(pop.element + " ");
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }


    }

    public void inOrderTraversal() {
        inOrderTraversal0(root);
    }

    public void inOrderTraversal0(Node<E> node) {
        if (node == null) return;
        inOrderTraversal0(node.left);
        System.out.print(node.element + " ");
        inOrderTraversal0(node.right);
    }

    //有左一直压左，否则弹出栈顶元素判断当前节点是否有右，如果有右再压右
    public void inOrderTraversal(Node<E> node) {
        if (node != null) {
            Stack<Node<E>> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    Node<E> pop = stack.pop();
                    System.out.print(pop.element + " ");
                    node = pop.right;

                }

            }

        }


    }

    public void postOrderTraversal() {
        postOrderTraversal0(root);
    }

    public void postOrderTraversal0(Node<E> node) {
        if (node == null) return;
        postOrderTraversal0(node.left);

        postOrderTraversal0(node.right);

        System.out.print(node.element + " ");
    }

    public void postOrderTraversal(Node<E> node) {
        if (node == null) return;
        Stack<Node<E>> stack = new Stack<>();
        Stack<Node<E>> helpStack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            helpStack.push(pop);
            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
        }

        while (!helpStack.isEmpty()) System.out.print(helpStack.pop().element + " ");
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    public void levelOrderTraversal(Node<E> node) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            System.out.print(poll.element + " ");
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
    }


    public int height() {
        return height(root);
    }

    public int height0(Node<E> node) {
        if (node == null) return 0;
        return Math.max(height0(node.left), height0(node.right)) + 1;

    }

    public int height(Node<E> node) {

        if (node == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(node);
        int height = 0;
        int levelSize = 1;
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            levelSize--;
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);

            if (levelSize == 0) {//意味着当前层遍历结束，即将遍历下一层 码值
                height++;
                levelSize = queue.size();
            }
        }
        return height;

    }

    public boolean isComplete(){
       return isComplete(root);
    }


    public boolean isComplete(Node<E> head) {
        if (head == null) return false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (isLeaf && !node.isLeafNode()) return false;
            //1.If node.left!=null && node.right!=null,add node.left and node.right to the queue
            if (node.hasTwoChildren()) {
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


    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        public Node() {
        }

        public Node(E element) {
            this.element = element;

        }

        protected boolean hasTwoChildren() {
            return this.left != null && this.right != null;
        }

        protected boolean isLeafNode() {
            return this.left == null && this.right == null;
        }
    }

}
