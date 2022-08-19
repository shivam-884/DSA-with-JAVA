package binaryTrees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data");
        }else{
            if(isLeft){
                System.out.println("Enter left child of " + parentData);
            }else{
                System.out.println("Enter right child of " + parentData);
            }
        }

        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static BinaryTreeNode<Integer> takeTreeInput(){
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root){
        // TODO take care of base case
        if(root == null){
            return;
        }
        System.out.print(root.data + ": ");
        if(root.left !=  null){
            System.out.print("L"+root.left.data + ", ");
        }
        if(root.right !=  null){
            System.out.print("R"+root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static void printTree(BinaryTreeNode<Integer> root){
        // TODO take care of base case
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static int numNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftNodeCount = numNodes(root.left);
        int rightNodeCount = numNodes(root.right);
        return 1 + leftNodeCount + rightNodeCount;
    }

    public static int largest(BinaryTreeNode<Integer> root){
        if(root == null){
            return -1;
        }
        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);

        if(root.data >= largestLeft){
            if(root.data >= largestRight){
                return root.data;
            }else {
                return largestRight;
            }
        }else if(largestLeft >= largestRight){
            return largestLeft;
        }else {
            return largestRight;
        }
    }

    public static int countNodeGreaterThanX(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return 0;
        }
        int leftTotal = countNodeGreaterThanX(root.left, x);
        int rightTotal = countNodeGreaterThanX(root.right,x);

        if(root.data > x){
            return leftTotal + rightTotal + 1;
        }else{
            return leftTotal + rightTotal;
        }
    }

    public static int height(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight >= rightHeight){
            return leftHeight + 1;
        }else{
            return rightHeight + 1;
        }
    }

    //    public static int numLeaves(BinaryTreeNode<Integer> root){
//        if(root == null){
//            return 0;
//        }
//        int leafLeft = numLeaves(root.left);
//        int leafRight = numLeaves(root.right);
//
//        if(leafLeft == 0 && leafRight == 0){
//            return leafLeft+1;
//        }else{
//            return leafLeft + leafRight;
//        }
//    }

    public static int numLeaves(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return numLeaves(root.left) + numLeaves(root.right);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k){
        if (root == null){
            return;
        }
        if(k == 0){
            System.out.println(root.data);
            return;
        }
        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right, k-1);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
            //Your code goes here
            if(root == null){
                return;
            }
            changeToDepthTree(root.left);
            changeToDepthTree(root.right);

    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        BinaryTreeNode<Integer> temp = root.left;
        return root;
    }

    public static void mirrorOfTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        mirrorOfTree(root.left);
        mirrorOfTree(root.right);
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static boolean isBalancedTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        boolean isLeftBalanced = isBalancedTree(root.left);
        boolean isRightBalanced = isBalancedTree(root.right);
        return isLeftBalanced && isRightBalanced;
    }

    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if (root == null){
            int height = 0;
            boolean isBal = true;
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        if(Math.abs(leftOutput.height - rightOutput.height) > 1){
            isBal = false;
        }

        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }

    public static BinaryTreeReturn1 diameter(BinaryTreeNode<Integer> root){
        if (root == null){
            int height = 0;
            int d = 0;
            BinaryTreeReturn1 ans = new BinaryTreeReturn1();
            ans.height = height;
            ans.diameter = d;
            return ans;
        }

        BinaryTreeReturn1 ld = diameter(root.left);
        BinaryTreeReturn1 rd = diameter(root.right);
        int d = 1;
        int height = 1 + Math.max(ld.height, rd.height);

        if(ld.height == 0 && rd.height == 0){
            d = 1;
        }else if(ld.height != 0 && rd.height == 0){
            d = ld.height + 1;
        }else if(ld.height == 0){
            d = rd.height + 1;
        }else {
            d = ld.height + rd.height + 1;
        }
        BinaryTreeReturn1 ans = new BinaryTreeReturn1();
        ans.height = height;
        ans.diameter = d;
        return ans;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = s.nextInt();

        if(rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();

        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();
            if(left != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }

            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();
            if(right != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return ;
        Queue<BinaryTreeNode<Integer>> q1=new LinkedList<BinaryTreeNode<Integer>>();
        Queue<BinaryTreeNode<Integer>> q2=new LinkedList<BinaryTreeNode<Integer>>();
        q1.add(root);
        while(!q1.isEmpty()){

            BinaryTreeNode<Integer> front=q1.remove();

            System.out.print(front.data+" ");
            if(front.left!=null)
                q2.add(front.left);

            if(front.right!=null)
                q2.add(front.right);

            if(q1.isEmpty()){
                q1=q2;
                q2=new LinkedList<BinaryTreeNode<Integer>>();
                System.out.println();
            }
        }
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] pre, int[] in, int siPre, int eiPre, int siIn, int eiIn){
        if(siPre > eiPre){
            return null;
        }
        int rootData = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

        int rootIndex = -1;
        for(int i = siIn; i<= eiIn; i++){
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }

        // I am assuming that root actually present in inorder

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;
        int siInRight = rootIndex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;

        int leftSubtreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubtreeLength - 1;
        int siPreRight = eiPreLeft + 1;

        BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
        root.left = left;
        root.right = right;
        return root;

    }

    public static BinaryTreeNode<Integer> buildTreeFromPreIn(int pre[], int in[]){
        BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(pre, in,0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
        return build(postorder, postorder.length - 1, inorder, 0, inorder.length -1);
    }

    private static BinaryTreeNode<Integer> build(int[] postorder, int posIdx, int[] inorder, int inStart, int inEnd){
        if(inStart > inEnd || posIdx < 0) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postorder[posIdx]);
        int i = 0;
        for(i = inStart; i <= inEnd; i ++){
            if(inorder[i] == postorder[posIdx]) break;
        }

        root.right = build(postorder, posIdx - 1, inorder, i + 1, inEnd);
        root.left = build(postorder, posIdx - 1 - (inEnd - i), inorder, inStart, i - 1);
        return root;
    }

    public static Pair<Integer, Integer> findMinMax(BinaryTreeNode<Integer> root){
       Pair<Integer, Integer> ans;
        if(root.left == null && root.right == null){
            ans = new Pair<>(root.data, root.data);
            return ans;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()){
            BinaryTreeNode<Integer> front = q.poll();
            if(front.data <= min){
                min = front.data;
            }
            if(front.data >= max){
                max = front.data;
            }
            if(front.left != null){
                q.add(front.left);
            }
            if(front.right != null){
                q.add(front.right);
            }
        }
        ans = new Pair<>(min, max);
        return ans;
    }

    public static boolean searchBST(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        if(data < root.data){
            return searchBST(root.left, data);
        }
        return searchBST(root.right, data);

    }

    public static void printBetweenK1K2(BinaryTreeNode<Integer> root, int k1, int k2){
        if (root == null) {
            return;
        }
        if (k1 < root.data) {
            printBetweenK1K2(root.left, k1, k2);
        }
        if (k1 <= root.data && k2 >= root.data) {
            System.out.print(root.data + " ");
        }
        printBetweenK1K2(root.right, k1, k2);
    }

    public static void print(BinaryTreeNode<Integer> root, int k, String path){
        if(root == null){
            return;
        }
        if(root.data == k && root.left == null && root.right == null){
            path += Integer.toString(root.data) + " ";
            System.out.println(path +  " ");
        }else{
            path += Integer.toString(root.data) + " ";
        }
        k -= root.data;
        if(k < 0){
            return;
        }
        print(root.left, k, path);
        print(root.right, k, path);
    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        //Your code goes here
        String path = "";
        print(root, k, path);
    }

    public static int maximum(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int maxLeft = maximum(root.left);
        int maxRight = maximum(root.right);
        return Math.max(root.data, Math.max(maxLeft, maxRight));
    }
    public static int minimum(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftMax = maximum(root.left);
        if(leftMax >= root.data){
            return false;
        }
        int rightMin = minimum(root.right);
        if(rightMin < root.data){
            return false;
        }
        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        return isLeftBST && isRightBST;
    }
    public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root){
        if(root == null){
            IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }

        IsBSTReturn leftAns = isBST2(root.left);
        IsBSTReturn rightAns = isBST2(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
        boolean isBST = true;
        if(leftAns.max >= root.data){
            isBST =true;
        }
        if(rightAns.min < root.data){
            isBST = false;
        }
        if(!leftAns.isBST){
            isBST = false;
        }
        if(!rightAns.isBST){
            isBST = false;
        }
        IsBSTReturn ans = new IsBSTReturn(min, max, isBST);
        return ans;
    }
    public static boolean isBST3(BinaryTreeNode<Integer> root, int minRange, int maxRange){
        if(root == null){
            return true;
        }
        if(root.data < minRange || root.data > maxRange){
            return false;
        }
        boolean isLeftWithinRange = isBST3(root.left, minRange, root.data-1);
        boolean isRightWithinRange = isBST3(root.right, root.data, maxRange);
        return isLeftWithinRange && isRightWithinRange;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        return SortedArrayToBST(arr, 0, n-1);
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int si, int ei){
        if(si <= ei) {
            int mid = si + (ei - si) / 2;
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
            BinaryTreeNode<Integer> leftChild = SortedArrayToBST(arr, si, mid - 1);
            BinaryTreeNode<Integer> rightChild = SortedArrayToBST(arr, mid + 1, ei);
            root.left = leftChild;
            root.right = rightChild;
            return root;
        }
        return null;
    }


    public static void main(String args[]){
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//        root.left = rootLeft;
//        root.right = rootRight;
//
//
//        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
//        rootLeft.right = twoRight;
//        rootRight.left = threeLeft;

//        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0,true);
//        printTreeDetailed(root);

//        System.out.println("Num Nodes " + numNodes(root));
//        System.out.println("Largest " + largest(root));
//        System.out.println(numLeaves(root));
//        System.out.println(countNodeGreaterThanX(root, 2));
//        System.out.println(height(root));
//        System.out.println("Print at depth k ");
//        printAtDepthK(root, 2);
//        changeToDepthTree(root);
//        printTreeDetailed(root);
//        BinaryTreeNode<Integer> newRoot = removeLeaves(root);
//        printTreeDetailed(newRoot);
//        mirrorOfTree(root);
//        printTreeDetailed(root);

//        System.out.println(isBalancedTree(root));
//        System.out.println("Is Balanced " + isBalancedBetter(root).isBalanced);

//        System.out.println("diameter : " + diameter(root).diameter );


//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        printTreeDetailed(root);

        int in[] = {1,2,3,4,5,6,7};
        int pre[] = {4,2,1,3,6,5,7};
        int post[] = {4, 5, 2, 6, 7, 3, 1};

//        BinaryTreeNode<Integer> root = buildTreeFromPreIn(pre,in);
//        BinaryTreeNode<Integer> root = buildTree(in, post);
//        printTreeDetailed(root);

//        Pair<Integer, Integer> ans = findMinMax(root);
//        System.out.println("min " + ans.minimum + "max " + ans.maximum);

        BinaryTreeNode<Integer> root = buildTreeFromPreIn(pre,in);
        System.out.println(searchBST(root, 9));
//        System.out.println(isBST(root));
        IsBSTReturn ans = isBST2(root);
        System.out.println(ans.min + " " + ans.max +" " + ans.isBST);
//        int[] arr = {1,2,3,4,5,6,7};
//        BinaryTreeNode<Integer> root = SortedArrayToBST(arr, 7);
//        printTreeDetailed(root);

    }
}
