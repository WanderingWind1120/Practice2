package org.example;

public class BinarySearchTree {
    Node root;

    public Node insertNode (Node node){
        root = insertHelper(root, node);
        return root;
    }
    public Node insertHelper (Node root, Node node){
        if (root == null){
            root = node;
            return root;
        }
        else if (node.data > root.data){
            insertHelper(node.right, node);
        }
        else {
            insertHelper(node.left,node);
        }
        return root;
    }
    public boolean searchNode (int data){
        return  searchHelper(root, data);
    }
    public boolean searchHelper(Node root, int data){
        if (root == null) {
            return false;
        }
        if (data > root.data){
            searchHelper(root.right,data);
        }
        else if (data < root.data){
            searchHelper(root.left, data);
        }
        return true;
    }
    public void displayNode(){
        displayHelper(root);
    }
    public void displayHelper (Node root){
        if (root != null){
            displayHelper(root.left);
            System.out.println(root.data)
            displayHelper(root.right);
        }
    }
    public void removeNode (int data){
        if (searchNode(data)){
            removeHelper(root, data);
        }
        else System.out.println("Node is not founded");
    }
    public Node removeHelper (Node root, int data){
        if (data > root.data){
            removeHelper(root.right, data);
        }
        else if (data < root.data){
            removeHelper(root.left, data);
        }
        else {
            if (root.right == null && root.left == null){
                root = null;
            }
            else if ( root.right != null){
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }
    public int successor (Node root){
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root.data;
    }
    public int predecessor (Node root){
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root.data;
    }

}
