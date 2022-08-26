package binaryTrees;

import queue.QueueEmptyException;
import queue.QueueUsingLL;

import java.util.*;

public class TreeTest {

    public static TreeNode<Integer> takeInputLevelWise() throws QueueEmptyException {
        Scanner s = new Scanner(System.in);
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        System.out.println("Enter the root data");
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()){
            TreeNode<Integer> front = pendingNodes.dequeue();
            System.out.println("Enter the no of children for: " + front.data);
            int numChild = s.nextInt();
            for(int i=0; i<numChild; i++){
                System.out.println("Enter the " + i + "th child data for: " + front.data);
                int childData = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childData);
                front.children.add(childNode);
                pendingNodes.enqueue(childNode);
            }
        }
        return root;
    }

    public static int numberOfNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 1;
        for(int i=0; i<root.children.size(); i++){
            int childCount = numberOfNodes(root.children.get(i));
            count += childCount;
        }
        return count;
    }

    public static int sumOfAllNode(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int sum = root.data;
        for(int i=0; i<root.children.size(); i++){
            int childSum = sumOfAllNode(root.children.get(i));
            sum += childSum;
        }
        return sum;
    }

    public static void printTree(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        for(int i=0; i<root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.data > x){
            count = 1;
        }
        for(int i=0; i<root.children.size(); i++){
            int childCount = numNodeGreater(root.children.get(i), x);
            count += childCount;
        }
        return count;
    }

//    public static int heightOfTree(TreeNode<Integer> root){
//        if(root == null){
//            return 0;
//        }
//      List<Integer> arr = new ArrayList<>();
//        for(int i=0; i<root.children.size(); i++){
//            int childHeight = heightOfTree(root.children.get(i));
//            arr.add(childHeight);
//        }
//        if(arr.isEmpty()){
//            return 1;
//        }
//        return Collections.max(arr) + 1;
//    }

    public static int heightOfTree(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        for(TreeNode<Integer> child : root.children){
            int childHeight = heightOfTree(child);
            if(childHeight > ans){
                ans = childHeight;
            }
        }
        return ans + 1;
    }

    public static int countLeafNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.children.isEmpty()){
            return 1;
        }
        int ans = 0;
        for(int i=0; i<root.children.size(); i++){
            int leafNodeCount = countLeafNodes(root.children.get(i));
            ans += leafNodeCount;
        }
        return ans;
    }

    public static void printPostOrder(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        for(TreeNode<Integer> child : root.children){
           printPostOrder(child);
        }
        System.out.print(root.data + " ");
    }

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        boolean output = false;
        for(int i=0; i<root.children.size(); i++){
            boolean subOutput = checkIfContainsX (root.children.get(i), x);
            if(subOutput){
                output = true;
            }
        }
        return output;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
       MaxSumNodeReturn ans = maxSumNodeHelper(root);
       return ans.node;

    }

    private static int findSum(ArrayList<TreeNode<Integer>> arr){
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i).data;
        }
        return sum;
    }
    public static MaxSumNodeReturn maxSumNodeHelper(TreeNode<Integer> root){
        if(root == null){
            return new MaxSumNodeReturn(null, 0);
        }
        int sum = root.data + findSum(root.children);
        MaxSumNodeReturn ans = new MaxSumNodeReturn(root, sum);
        for(int i=0; i<root.children.size(); i++){
            MaxSumNodeReturn childAns = maxSumNodeHelper(root.children.get(i));
            if(childAns.sum >= sum){
                ans.sum = childAns.sum;
                ans.node = childAns.node;
            }
        }
        return ans;
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 == null){
            return false;
        }
        if(root1 == null && root2 != null){
            return false;
        }
        if(root1.children.size() != root2.children.size()){
            return false;
        }
        boolean ans = true;
        for(int i=0; i<root1.children.size(); i++){
            if(ans) {
                boolean childAns = checkIdentical(root1.children.get(i), root2.children.get(i));
                ans = ans && childAns;
            }else{
                return ans;
            }
        }
        return ans;
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root){
        replaceWithDepthValue(root, 0);
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root, int depth){
        if(root == null){
            return;
        }
        root.data = depth;
        for(TreeNode<Integer> child : root.children){
            replaceWithDepthValue(child, depth+1);
        }
    }

    public static void printTreeBetter(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + ": ");
        for(int i=0; i<root.children.size(); i++){
            System.out.print(root.children.get(i).data +" ");
        }
        System.out.println();
        for(int i=0; i<root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printTreeBetter(child);
        }
    }

    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> q1 = new LinkedList<>();
        Queue<TreeNode<Integer>> q2 = new LinkedList<>();
        q1.add(root);

        while (!q1.isEmpty()) {
        TreeNode<Integer> front = q1.remove();
        System.out.print(front.data + " ");

            for (int i = 0; i < front.children.size(); i++) {
                q2.add(front.children.get(i));
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
            System.out.println();
            }
        }
    }

    public static void main(String[] args) throws QueueEmptyException {
//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>(1);
//        TreeNode<Integer> node4 = new TreeNode<>(5);
//        TreeNode<Integer> node5 = new TreeNode<>(6);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//
//        node2.children.add(node4);
//        node2.children.add(node5);

//        printTree(root);
        TreeNode<Integer> root = takeInputLevelWise();
//        printTreeBetter(root);
        printLevelWise(root);
        System.out.println("Number of Nodes : " + numberOfNodes(root));
//        System.out.println("Number of Nodes greater than X " + numNodeGreater(root, 10));
//        System.out.println(heightOfTree(root));
//        System.out.println(countLeafNodes(root));
//        printPostOrder(root);
//        System.out.println(checkIfContainsX(root, 300));
//        TreeNode<Integer> ans = maxSumNode(root);
//        System.out.println(ans.data);
//        TreeNode<Integer> root1 = takeInputLevelWise();
//        System.out.println(checkIdentical(root, root1));
        replaceWithDepthValue(root);
        printLevelWise(root);
    }

}
