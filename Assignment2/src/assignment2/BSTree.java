//boolean checkBST(Node root) {
//        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    boolean check(Node node, int min, int max) {
//        if (node == null) {
//            return true;
//        }
//
//        if (node.data < min || node.data > max) {
//            return false;
//        }
//
//        return check(node.left, min, node.data - 1) && check(node.right, node.data + 1, max);
//    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author 174093G
 */
public class BSTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BSTNode x = new BSTNode(7);
        System.out.println(x);//reference of the object
        BSTreeApp b = new BSTreeApp();
        b.addNode(6);
        b.addNode(8);
        b.findNode(7);
        b.inorderTraversal(b.root);

    }

}

class BSTNode {

    int data;
    BSTNode leftChild;
    BSTNode rightChild;

    public BSTNode(int data) {
        this.data = data;
    }

    @Override//override default toString method in super class
    public String toString() {
        return "data -> " + data;
    }

    public int minValue() {

        if (this.leftChild == null) {
            return this.data;
        }
        return this.leftChild.minValue();
    }

    public boolean remove(int data, BSTNode parent) {
        if (data < this.data) {
            if (this.leftChild == null) {
                return false;
            }
            return this.leftChild.remove(data, this);//self object is the parent
        } else if (data > this.data) {
            if (this.rightChild == null) {
                return false;
            }
            return this.rightChild.remove(data, this);
        } else {
            if (this.leftChild != null && this.rightChild != null) {
                this.data = this.rightChild.minValue();
                this.rightChild.remove(this.data, this);
            } else if (parent.leftChild == this) {
                parent.leftChild = this.leftChild == null ? rightChild : leftChild;
            } else {
                parent.rightChild = this.leftChild == null ? rightChild : leftChild;
            }
            return true;
        }

    }

}

class BSTreeApp {

    BSTNode root;

    public BSTreeApp() {
        this.root = null;//no need to give it is null
    }

    public void addNode(int data) {
        BSTNode n = new BSTNode(data);
        BSTNode current = root;
        BSTNode parent = null;

        if (root == null) {
            root = n;
            return;
        }
        while (true) {
            parent = current;
            if (current.data > n.data) {

                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = n;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = n;
                    return;
                }

            }
        }

    }

    public BSTNode findNode(int data) {
        BSTNode current = root;
        while (true) {
            if (current == null) {

                return null;
            }
            if (data == current.data) {

                return current;
            }
            if (data < current.data) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
    }

    public void preorderTraversal(BSTNode currentNode) {//provided one
        if (currentNode == null) {
            return;
        }
        System.out.println(currentNode);
        preorderTraversal(currentNode.leftChild);
        preorderTraversal(currentNode.rightChild);
    }

    public void postorderTraversal(BSTNode currentNode) {

        if (currentNode == null) {
            return;
        }
        postorderTraversal(currentNode.leftChild);
        postorderTraversal(currentNode.rightChild);
        System.out.println(currentNode);
    }

    public void inorderTraversal(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        inorderTraversal(currentNode.leftChild);
        System.out.println(currentNode);
        inorderTraversal(currentNode.rightChild);

    }

    public boolean remove(int data) {
        if (root == null) {
            return false;
        } else if (data == root.data) {
            if (root.leftChild == null) {
                root = root.rightChild;
            } else if (root.rightChild == null) {
                root = root.leftChild;
            } else {
                return root.remove(data, null);
            }
            return true;
        } else {
            return root.remove(data, null);
        }
    }

}
