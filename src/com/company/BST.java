package com.company;

public class BST  <K extends Comparable<K>,V> {
    private Node root;
    private class Node {
        private K key;
        private V val;
        private int Nodes;
        private Node left, right;
        public Node(K key, V val, int Nodes) {
            this.key = key;
            this.val = val;
            this.Nodes = Nodes;
        }
    }
        public int size(){
            return size(root);
        }
        private int size(Node x){
            if (x==null) return 0;
            else return x.Nodes;
        }
        public V get(K key){
            return get(root,key);
        }
        private V get(Node root,K key){
            if (root==null){
                return null;
            }
            int compare= key.compareTo(root.key);
            if(compare>0){
                return get(root.right,key);
            }
            else if(compare<0){
                return get(root.left,key);
            }
            else {
                return root.val;
            }
        }
        public void put(K key, V val){


        }
        private Node put(K key, V val, Node root){
        if(root == null){
            new Node(key,val,1);
        }
        int compare= key.compareTo(root.key);
        if(compare>0){
            root.right=put(key,val,root.right);
        }
        else if(compare<0){
            root.left=put(key,val,root.left);
        }
        root.Nodes=size(root.left)+size(root.left)+1;
        return root;
        }
        public void delete(K key){
        root=delete(root,key);
        }
        public Node delete(Node root, K key){
        if (root == null){
            return null;
        }
        int compare = key.compareTo(root.key);
        if(compare<0){
            root.left = delete(root.left, key);
        }
        else if(compare>0){
            root.right = delete(root.right, key);
        }
        else
        {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            Node t = root;
            root = min(t.right); // See page 407.
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
            root.Nodes = size(root.left) + size(root.right) + 1;
            return root;
        }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.Nodes = size(x.left) + size(x.right) + 1;
        return x;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }
}
