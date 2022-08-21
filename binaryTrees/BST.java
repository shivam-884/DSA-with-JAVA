package binaryTrees;

public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x){
        if(node == null){
            return false;
        }
        if(node.data == x){
            return true;
        }
        if(x < node.data){
            // Call on left side
            return isPresentHelper(node.left, x);
        }else{
            // Call on right side
            return isPresentHelper(node.right, x);
        }
    }

    public boolean isPresent(int x){
         return isPresentHelper(root, x);
    }

    public void insert(int x){
       root = insertHelper(root, x);
    }

    public boolean deleteData(int x){
        return false;
    }

    public int size(){
        return size;
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> node){
        if (node == null) {
            return;
        }
        System.out.print(node.data + ": ");
        if (node.left != null) {
            System.out.print("L" + node.left.data + ", ");
        }
        if (node.right != null) {
            System.out.print("R" + node.right.data);
        }
        System.out.println();
        printTreeHelper(node.left);
        printTreeHelper(node.right);
    }

    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x){
       if(node == null){
           BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
           return newRoot;
       }

       if(x >= node.data){
           node.right = insertHelper(node.right, x);
       }else{
           node.left = insertHelper(node.left, x);
       }
       return node;
    }

    public void printTree(){
        printTreeHelper(root);
    }
}
