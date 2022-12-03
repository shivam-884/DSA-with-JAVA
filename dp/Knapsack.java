package dp;

public class Knapsack {

    // Recursive Approach
    public static int knapsackR(int[] weights, int[] values, int maxWeight){
        return knapsackRHelper(weights,values,maxWeight,0);
    }

    private static int knapsackRHelper(int[] weights, int[] values, int maxWeight, int i) {

        if(i == values.length){
            return 0;
        }

        int ans;
        if(weights[i] <= maxWeight){
            // Including the ith item
            int ans1 = values[i] + knapsackRHelper(weights,values,maxWeight-weights[i],i+1);
            // Excluding the ith item
            int ans2 = knapsackRHelper(weights,values,maxWeight,i+1);

            ans = Math.max(ans1,ans2);
        }else{
            ans = knapsackRHelper(weights,values,maxWeight,i+1);
        }
        return ans;
    }

    // Iterative Approach

    public static int knapsackI(int[] weights, int[] values, int maxWeight){
        int m = values.length;

        int[][] dp = new int[m+1][maxWeight+1];
        for(int i=m-1; i>=0; i--){
            for(int w=0; w<=maxWeight; w++){
                int ans;
                if(weights[i] <= w){
                    int ans1 = values[i] + dp[i+1][w-weights[i]];
                    int ans2 = dp[i+1][w];
                    ans = Math.max(ans1,ans2);
                }else{
                    ans = dp[i+1][w];
                }
                dp[i][w] = ans;
            }
        }
        return dp[0][maxWeight];
    }

    public static void main(String[] args) {
        int[] weights = {1,2,4,5};
        int[] values = {5,4,8,6};
        int maxWeight = 5;
//        System.out.println(knapsackR(weights,values,maxWeight));
        System.out.println(knapsackI(weights,values,maxWeight));
    }

}
