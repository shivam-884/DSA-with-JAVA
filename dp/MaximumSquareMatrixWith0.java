package dp;

public class MaximumSquareMatrixWith0 {
    public static int findMaxSquareWithAllZeros(int[][] input){

        if(input.length == 0 || input[0].length == 0){
            return 0;
        }
        int[][] dp = new int[input.length][input[0].length];

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0){
                    if(input[i][j] == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }else if(j==0){
                    if(input[i][j] == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }else if(input[i][j] == 0){
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    int ans3 = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(ans1,Math.min(ans2,ans3));
                }else{
                    dp[i][j] = 0;
                }
                if(dp[i][j] > ans){
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] input = {{1,1,1,1},{1,0,0,0},{1,0,0,1}};
        System.out.println(findMaxSquareWithAllZeros(input));
    }
}
