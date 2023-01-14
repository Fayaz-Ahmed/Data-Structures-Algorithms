package javaapplication9;

import java.util.Stack;
import javax.swing.tree.TreeNode;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode {

        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");

        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = three;

        second.left = fourth;
        second.right = five;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
//    public void preOrder() {
//        if (root == null) {
//            return;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode temp = stack.pop();
//            System.out.print(temp.data + " ");
//            if (temp.right != null) {
//                stack.push(temp.right);
//            }
//            if (temp.left != null) {
//                stack.push(temp.left);
//            }
//        }
//    }

//    public void inOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left);
//        System.out.println(root.data + " ");
//        inOrder(root.right);
//
//    }
    public void inOrder(TreeNode root) { //recursive
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void inOrder() {//iterative
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = height(root.left);
            int right = height(root.right);
            if (left > right) {
                return 1 + left;
            } else {
                return 1 + right;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        //   bt.inOrder(bt.root);
        //bt.preOrder(bt.root);
        bt.inOrder();
        bt.height(bt.root);
    }
}
