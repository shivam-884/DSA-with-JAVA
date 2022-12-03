package dp;

import java.net.Inet4Address;
import java.util.HashMap;

public class ProblemSet {

    /*    ####### Iterative Approach   */
    public static int minStepsTo1(int n){
        if(n == 1){
            return 0;
        }
        int ans1 = minStepsTo1(n-1);
        int ans2 = Integer.MAX_VALUE;
        if(n%2 == 0){
            ans2 = minStepsTo1(n/2);
        }
        int ans3 = Integer.MAX_VALUE;
        if(n%3 == 0){
            ans3 = minStepsTo1(n/3);
        }
        int myAns = 1 + Math.min(ans1,Math.min(ans2,ans3));
        return myAns;
    }

    /*     ###### Using DP     */

    public static int minStepsTo1DP(int n, int[] dp){
        if(n == 1){
            return 0;
        }
        int ans1;
        if(dp[n-1] == -1){
            ans1 = minStepsTo1DP(n-1,dp);
            dp[n-1] = ans1;
        }else{
            ans1 = dp[n-1];
        }

        int ans2 = Integer.MAX_VALUE;
        if(n%2 == 0) {
            if (dp[n / 2] == -1) {
                ans2 = minStepsTo1DP(n / 2, dp);
                dp[n / 2] = ans2;
            } else {
                ans2 = dp[n / 2];
            }
        }

        int ans3 = Integer.MAX_VALUE;
        if(n%3 == 0) {
            if (dp[n / 3] == -1) {
                ans3 = minStepsTo1DP(n / 3, dp);
                dp[n / 3] = ans3;
            } else{
                ans3 = dp[n / 3];
            }
        }
        int myAns = 1 + Math.min(ans1,Math.min(ans2,ans3));
        return myAns;
    }

    /*   ##### Minimum No of square to represent to N   ########   */

    public static int minSquares(int n,int[] dp){

        if(n==0){
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            int currAns;
            if(dp[n-(i*i)] == -1){
                currAns = minSquares(n-(i*i),dp);
                dp[n-(i*i)] = currAns;
            }else{
                currAns = dp[n-(i*i)];
            }
            if(minAns > currAns){
                minAns = currAns;
            }
        }
        int myAns = 1 + minAns;
        return myAns;
    }


    /*##### Iterative Approach   ####*/

    public static int minSquareI(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            int minAns = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                int currAns = dp[i-(j*j)];
                if(minAns > currAns){
                    minAns = currAns;
                }
            }
            dp[i] = 1 + minAns;
        }
        return dp[n];
    }

      /* ###### Bytelandian Problem(coin change)    ######### */
    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        if(n == 0 || n == 1){
            return n;
        }
        long ans1;
        if(memo.containsKey(n/2)){
            ans1 = memo.get(n/2);
        }else{
            ans1 = bytelandian(n/2,memo);
            memo.put(n/2,ans1);
        }

        long ans2;
        if(memo.containsKey(n/3)){
            ans2 = memo.get(n/3);
        }else{
            ans2 = bytelandian(n/3,memo);
            memo.put(n/3,ans2);
        }

        long ans3;
        if(memo.containsKey(n/4)){
            ans3 = memo.get(n/4);
        }else{
            ans3 = bytelandian(n/4,memo);
            memo.put(n/4,ans3);
        }
        long myAns = ans1 + ans2 + ans3;
        return Math.max(myAns,n);
    }


    public static long bytelandian2(long n, HashMap<Long, Long> dp){
        if(n <= 1){
            return n;
        }
        if(dp.get(n) != null){
            return dp.get(n);
        }
        long breakDownValue = bytelandian2(n/2,dp) + bytelandian2(n/3,dp) + bytelandian2(n/4,dp);
        dp.put(n,Math.max(n,breakDownValue));
        return dp.get(n);
    }

    /*#######  Loot House Problem  #########*/
    public static int maxMoneyLooted(int[] houses) {
        //Your code goes here
        int[] dp = new int[houses.length];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        return helper(dp.length-1, houses, dp);
    }

    public static int helper(int i, int[] a, int[]dp){
        if(i <= -1){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int op1 = a[i] + helper(i-2,a,dp);
        int op2 = helper(i-1,a,dp);
        dp[i] = Math.max(op1, op2);
        return dp[i];
    }


//    Iterative Approach

    public static int maxMoneyLooted2(int[] houses){
        int n = houses.length;

        if(n==0){
            return 0;
        }
        if(n==1){
            return houses[0];
        }
        int[] maxMoneyLooted = new int[n];
        maxMoneyLooted[0] = houses[0];
        maxMoneyLooted[1] = Math.max(houses[0],houses[1]);
        for(int currHouse = 2; currHouse < n; currHouse++){
            maxMoneyLooted[currHouse] = Math.max(maxMoneyLooted[currHouse-1],(houses[currHouse]+maxMoneyLooted[currHouse-2]));
        }
        return maxMoneyLooted[n-1];
    }
      /*######  Coin Tower - Coin with three choices   ########*/
    public static String findWinner(int n, int x, int y) {
        //Your code goes here
        if(n==1){
            return "Beerus";
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int currCoin = 2; currCoin <= n; currCoin++){
            int ans1;
            if(currCoin-1 < 0){
                ans1 = 1;
            }else{
                ans1 = dp[currCoin-1];
            }

            int ans2;
            if(currCoin-x < 0){
                ans2 = 1;
            }else{
                ans2 = dp[currCoin-x];
            }

            int ans3;
            if(currCoin-y < 0){
                ans3 = 1;
            }else{
                ans3 = dp[currCoin-y];
            }
            dp[currCoin] = Math.max(ans1^1, Math.max(1^ans2,1^ans3));
        }
        if(dp[n] == 1){
            return "Beerus";
        }else{
            return "Whis";
        }
    }

    public static String findWinner2(int n, int x, int y){
        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }
        boolean[] dp = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(i==1 || i==x || i==y){
                dp[i] = true;
            }else if(i < x){
                dp[i] = !dp[i-1];
            }else if(i < y){
                dp[i] = !(dp[i-x] && dp[i-1]);
            }else{
                dp[i] = !(dp[i-x] && dp[i-y] && dp[i-y] && dp[i-1]);
            }
        }
        boolean result = dp[n];

        if(result){
            return "Beerus";
        } else {
            return "Whis";
        }
    }


    /*######  Min Cost Path  Problem   ##########*/

//    Recursive Approach
    public static int minCostPath(int[][] input){
        return minCostPathHelper(input, 0, 0);
    }
    public static int minCostPathHelper(int[][] input, int m, int n){
        if(m==input.length-1 && n == input[0].length-1){
            return input[m][n];
        }

        if(m > input.length-1 || n > input[0].length-1){
            return Integer.MAX_VALUE;
        }

        int ans1 = minCostPathHelper(input, m+1, n);
        int ans2 = minCostPathHelper(input, m, n+1);
        int ans3 = minCostPathHelper(input, m+1, n+1);

        return input[m][n] + Math.min(ans1, Math.min(ans2,ans3));
    }

//    Memoization
     public static int minCostPath2(int[][] input){
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return minCostPathHelper2(input, 0,0,dp);
        }
    public static int minCostPathHelper2(int[][] input, int m, int n, int[][] dp){
        if(m==input.length-1 && n == input[0].length-1){
            return input[m][n];
        }

        if(m > input.length-1 || n > input[0].length-1){
            return Integer.MAX_VALUE;
        }

        int ans1, ans2, ans3;
        if(dp[m+1][n] == Integer.MIN_VALUE){
            ans1 = minCostPathHelper2(input, m+1, n, dp);
            dp[m+1][n] = ans1;
        }else{
            ans1 = dp[m+1][n];
        }

        if(dp[m][n+1] == Integer.MIN_VALUE){
            ans2 = minCostPathHelper2(input, m, n+1,dp);
            dp[m][n+1] = ans2;
        }else{
            ans2 = dp[m][n+1];
        }

        if(dp[m+1][n+1] == Integer.MIN_VALUE){
            ans3 = minCostPathHelper2(input, m+1, n+1,dp);
            dp[m+1][n+1] = ans3;
        }else{
            ans3 = dp[m+1][n+1];
        }
        return input[m][n] + Math.min(ans1, Math.min(ans2,ans3));
    }

//    Iterative Approach

    public static int minCostPathI(int[][] input){
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1){
                    dp[i][j] = input[i][j];
                    continue;
                }
                dp[i][j] = input[i][j] + Math.min(dp[i+1][j], Math.min(dp[i][j+1],dp[i+1][j+1]));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int n = 6;
    //  System.out.println(minStepsTo1(n));
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
//        System.out.println(minStepsTo1DP(n,dp));
//        System.out.println(minSquareI(n));
        HashMap<Long, Long> memo = new HashMap<>();
//        System.out.println(bytelandian(24,memo));
        int[] house = {10,2,30,20,3,50};
//        System.out.println(maxMoneyLooted(house));
//        System.out.println(findWinner(10,2,4));
        int[][] input = {{1,5,11},{8,13,12},{2,3,7}};
        System.out.println(minCostPathI(input));
    }
}
