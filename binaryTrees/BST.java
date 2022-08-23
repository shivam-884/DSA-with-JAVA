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

    private static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public void insert(int x){
       root = insertHelper(root, x);
       size++;
    }

    private static BSTDeleterReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return new BSTDeleterReturn(null, false);
        }

        if(root.data < x){
            BSTDeleterReturn outputRight = deleteDataHelper(root.right, x);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;
        }

        if(root.data > x){
            BSTDeleterReturn outputLeft = deleteDataHelper(root.left, x);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }

        // 0 child
        if(root.left ==  null && root.right == null){
            return new BSTDeleterReturn(null, true);
        }

        // only left child
        if(root.left != null && root.right == null){
            return new BSTDeleterReturn(root.left, true);
        }

        // only right child
        if(root.left == null && root.right != null){
            return new BSTDeleterReturn(root.right, true);
        }

        // both children are present
        int rightMin = minimum(root.right);
        root.data = rightMin;
        BSTDeleterReturn outputRight = deleteDataHelper(root.right, rightMin);
        root.right = outputRight.root;
        return new BSTDeleterReturn(root,true);
    }
    public boolean deleteData(int x){
        BSTDeleterReturn output = deleteDataHelper(root, x);
        root = output.root;
        if(output.deleted){
            size--;
        }
        return output.deleted;
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

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root){
        LargestBSTHeight output = largestBSTHeightHelper(root);
        return output.height;
    }

    private static LargestBSTHeight largestBSTHeightHelper(BinaryTreeNode<Integer> root){
        if(root ==  null){
            return new LargestBSTHeight(Integer.MAX_VALUE, Integer.MIN_VALUE,true,0);
        }

        LargestBSTHeight leftOutput = largestBSTHeightHelper(root.left);
        LargestBSTHeight rightOutput = largestBSTHeightHelper(root.right);
        int min = Math.min(leftOutput.min, Math.min(root.data,rightOutput.min));
        int max = Math.max(leftOutput.max, Math.max(root.data,rightOutput.max));
        boolean isBst = false;
        if(root.data > leftOutput.max && root.data <= rightOutput.min){
            isBst = true;
        }
        int height = Math.max(leftOutput.height, rightOutput.height);
        if(isBst){
            height += 1;
        }
        return new LargestBSTHeight(min, max, isBst, height);
    }

}
