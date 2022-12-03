package dp;

public class EditDistance {

    public static int editDistance(String s, String t){
        int m = s.length();
        int n = t.length();
        int p = m, q = n;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++){
            dp[i][n] = p;
            p--;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[m][i] = q;
            q--;
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else {
                    int ans1 = dp[i+1][j+1];
                    int ans2 = dp[i+1][j];
                    int ans3 = dp[i][j+1];
                    dp[i][j] = 1 + Math.min(ans1,Math.min(ans2,ans3));
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        String s = "whgtdwhgtdg";
        String t = "aswcfg";
        System.out.println(editDistance(s,t));
    }
}
