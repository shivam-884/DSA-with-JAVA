package dp;

public class LongestCommonSubsequence {
    /*###### Recursive Approach  #####*/
    public static int lcs(String s, String t){
        return lcsHelper(s,t,0,0);
    }
    public static int lcsHelper(String s, String t, int i, int j){
        if(i == s.length() || j == t.length()){
            return 0;
        }
        int myAns;
        if(s.charAt(i) == t.charAt(j)){
            int smallAns = lcsHelper(s,t,i+1,j+1);
            myAns = 1 + smallAns;
        }else{
            int ans1 = lcsHelper(s,t,i+1,j);
            int ans2 = lcsHelper(s,t,i,j+1);
            myAns = Math.max(ans1,ans2);
        }
        return myAns;
    }

    /*#####  Memoization  #######*/
    public static int lcsM(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return lcsHelperM(s,t,0,0,dp);
    }
    public static int lcsHelperM(String s, String t, int i, int j, int[][] dp){
        if(i == s.length() || j == t.length()){
            return 0;
        }
        int myAns;
        if(s.charAt(i) == t.charAt(j)){
            int smallAns;
            if(dp[i+1][j+1] != -1){
                smallAns = dp[i+1][j+1];
            }else{
                smallAns = lcsHelperM(s,t,i+1,j+1,dp);
                dp[i+1][j+1] = smallAns;
            }
            myAns = 1 + smallAns;
        }else{
            int ans1;
            if(dp[i+1][j] != -1){
                ans1 = dp[i+1][j];
            }else{
                ans1 = lcsHelperM(s,t,i+1,j,dp);
                dp[i+1][j] = ans1;
            }
            int ans2;
            if(dp[i][j+1] != -1){
                ans2 = dp[i][j+1];
            }else{
                ans2 = lcsHelperM(s,t,i,j+1,dp);
                dp[i][j+1] = ans2;
            }
            myAns = Math.max(ans1,ans2);
        }
        return myAns;
    }

    /*##### Iterative Approach  ######*/
    public static int lcsI(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s = "abdgec";
        String t = "bfdmgjc";
        System.out.println(lcsI(s,t));
    }
}
