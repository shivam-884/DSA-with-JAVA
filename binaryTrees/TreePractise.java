package binaryTrees;

public class TreePractise {

  /*  Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are
    cousins of each other or not. Two nodes are said to be cousins of each other if they are
    at same level of the Binary Tree and have different parents. */
    public static int findLevel(BinaryTreeNode<Integer> root, int data, int level){
        if(root == null){
            return -1;
        }
        if(root.data == data){
            return level;
        }
        int left = findLevel(root.left, data, level+1);
        if(left != -1){
            return left;
        }
        return findLevel(root.right, data, level+1);
    }

    public static boolean isSiblings(BinaryTreeNode<Integer> root, int p, int q){
        if(root == null){
            return false;
        }

        if(root.left != null && root.right != null){
            if((root.left.data == p && root.right.data == q) || (root.left.data == q && root.right.data == p)){
                return true;
            }
        }
        boolean leftCheck = isSiblings(root.left,p, q);
        boolean rightCheck = isSiblings(root.right, p, q);
        return leftCheck && rightCheck;
    }

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q){
        int level1 = findLevel(root,p,0);
        int level2 = findLevel(root,q,0);

        return level1 == level2 && !isSiblings(root, p, q);
    }

    /* Given a binary tree, return the longest path from leaf to root. Longest means, a path which
    contain maximum number of nodes from leaf to root.
     */

    public static void main(String args[]){
        BinaryTreeUse b = new BinaryTreeUse();
        BinaryTreeNode<Integer> root = b.takeInputLevelWise();

        b.printTreeDetailed(root);

        System.out.println(isCousin(root,2,4));
    }

}
