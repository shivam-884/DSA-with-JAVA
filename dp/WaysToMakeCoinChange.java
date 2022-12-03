package dp;

public class WaysToMakeCoinChange {

    public static int waysToMakeCoinChange(int[] coins, int value){
        int[] dp = new int[value+1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<dp.length; j++){
                dp[j] += dp[j-coins[i]];
                }
            }
        return dp[value];
        }

    public static void main(String[] args) {
        int[] coins = {2,3,5};
        int value = 7;
        System.out.println(waysToMakeCoinChange(coins,value));
    }
}
