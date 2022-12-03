package dp;

public class Staircase {
    public static long staircase(int n) {
        //Your code goes here
        long[] dp = new long[n+1];

        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n == 3){
            return 4;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(staircase(10));
    }
}
