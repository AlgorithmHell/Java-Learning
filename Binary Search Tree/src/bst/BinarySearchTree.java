package bst;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Helga on 10/29/2017.
 */
public class BinarySearchTree<T extends  Comparable<T>> {
    private class Node {
        private T value;
        private Node left;
        private Node right;

        private Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree(T root) {
        this.root = new Node(root);
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean find(T value) {
        Node current = root;
        for (; current != null; current = (value.compareTo(current.value) < 0) ? current.left : current.right) {
            System.out.println(current.value);
            if (current.value.equals(value)) return true;
        }
        return false;
    }

    public void insert(T value) {
        Node newNode = new Node(value);
        Node parent = null;
        Node current = root;
        for (; current != null; current = (value.compareTo(current.value) < 0) ? current.left : current.right) {
            if (current.value.equals(value)) {
                current = newNode;
                return;
            }
            parent = current;
        }
        if (value.compareTo(parent.value) < 0) parent.left = current = newNode;
        else parent.right = current = newNode;
    }

    public void rootLeftRight() {
        if(root==null) return;
        System.out.print(root.value.toString() + " ");
        rootLeftRight(root.left);
        rootLeftRight(root.right);
    }

    private void rootLeftRight(Node node) {
        if (node == null) return;
        System.out.print(node.value.toString() + " ");
        rootLeftRight(node.left);
        rootLeftRight(node.right);
    }

    public void leftRightRoot() {
        if(root==null) return;
        leftRightRoot(root.left);
        leftRightRoot(root.right);
        System.out.print(root.value.toString() + " ");
    }

    private void leftRightRoot(Node node) {
        if (node == null) return;
        leftRightRoot(node.left);
        leftRightRoot(node.right);
        System.out.print(node.value.toString() + " ");
    }

    //In-Order
    public void leftRootRight() {
        if(root==null) return;
        leftRootRight(root.left);
        System.out.print(root.value.toString() + " ");
        leftRootRight(root.right);
    }

    private void leftRootRight(Node node) {
        if (node == null) return;
        leftRootRight(node.left);
        System.out.print(node.value.toString() + " ");
        leftRootRight(node.right);

    }

    private Node minimum(Node node) {
        if (node.left == null) return node;
        return minimum(node.left);
    }

     public void delete(T value) {
       root=delete(root,value);
     }
     @Nullable
     private Node delete(Node root, T value) {
        if(root==null) return root;
        if(value.compareTo(root.value)<0) root.left= delete(root.left,value);
        else {
            if (value.compareTo(root.value)>0) root. right=delete (root.right,value);
            else {
                if (root.left != null&&root.right!=null) {
                    root.value = minimum(root.right).value;
                    root.right=delete(root.right, root.value);
                }
                else {
                    if (root.right == null) root = root.left;
                    else root=root.right;
                }
            }
        }
        return root;
     }
}



