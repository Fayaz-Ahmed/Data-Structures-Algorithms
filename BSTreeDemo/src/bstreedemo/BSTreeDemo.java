/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstreedemo;

/**
 *
 * @author fatech98
 */
public class BSTreeDemo {

    public static void main(String[] args) {
        BSTree t = new BSTree();
        t.addNode(10);
        t.addNode(5);
        t.addNode(3);
        t.addNode(20);
        t.addNode(6);
        t.addNode(15);
        t.addNode(2);
        t.addNode(25);
       // t.addNode(10);
        System.out.print("inorder \n");
        t.inOrderTreversal(t.root);
        t.remove(10);
        System.out.println("");
        t.inOrderTreversal(t.root);
//        System.out.println("\npreorder");
//        t.preOrderTreversal(t.root);
//        System.out.println("\npostorder");
//        t.postOrderTreversal(t.root);
//        System.out.println("\nfind 6 = " + t.findNode(34));
    }
}

class BSTNode {

    int data;
    BSTNode leftChild;
    BSTNode rightChild;

    public BSTNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + ", ";
    }

    public int minValue() {
        if (this.leftChild == null) {
            return this.data;
        } else {
            return this.leftChild.minValue();
        }
    }

    public int maxValue() {
        if (this.rightChild == null) {
            return this.data;
        } else {
            return this.rightChild.maxValue();
        }
    }

    public boolean remove(int data, BSTNode parent) {//this method start from root node
        if (data < this.data) {
            if (this.leftChild != null) {
                return this.leftChild.remove(data, this);
            } else {
                return false;
            }
        } else if (data > this.data) {
            if (this.rightChild != null) {
                return this.rightChild.remove(data, this);
            } else {
                return false;
            }
        } else {
            if (this.leftChild != null && this.rightChild != null) {
                this.data = this.rightChild.minValue();
                this.rightChild.remove(this.data, this);
            } else if (parent.leftChild == this) {
                parent.leftChild = (this.leftChild == null) ? this.rightChild : this.leftChild;
            } else if (parent.rightChild == this) {
                parent.rightChild = (this.leftChild == null) ? this.rightChild : this.leftChild;
            }
            return true;
        }
    }
}

class BSTree {

    BSTNode root;

    public boolean remove(int data) {
        if (root == null) {
            return false;
        }
        if (root.leftChild == null) {
            root = root.rightChild;
        } else if (root.rightChild == null) {
            root = root.leftChild;
        }
        return root.remove(data, null);
    }

    public void addNode(int data) {
        BSTNode newNode = new BSTNode(data);
        if (root == null) {
            root = newNode;
        } else {
            BSTNode currentnode = root;
            while (true) {
                BSTNode parentNode = currentnode;
                if (newNode.data < currentnode.data) {
                    currentnode = currentnode.leftChild;
                    if (currentnode == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }
                } else {
                    currentnode = currentnode.rightChild;
                    if (currentnode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void preOrderTreversal(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.print(currentNode);
        preOrderTreversal(currentNode.leftChild);
        preOrderTreversal(currentNode.rightChild);
    }

    public void postOrderTreversal(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        postOrderTreversal(currentNode.leftChild);
        postOrderTreversal(currentNode.rightChild);
        System.out.print(currentNode);

    }

    public void inOrderTreversal(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        inOrderTreversal(currentNode.leftChild);
        System.out.print(currentNode);
        inOrderTreversal(currentNode.rightChild);
    }

    public BSTNode findNode(int data) {
        BSTNode currentNode = root;
        while (currentNode != null) {
            if (data == currentNode.data) {
                return currentNode;
            } else {
                if (data < currentNode.data) {
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
        }
        return null;
    }
}
