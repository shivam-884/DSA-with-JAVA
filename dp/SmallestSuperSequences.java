package dp;

public class SmallestSuperSequences {
    public static int smallestSuperSequence(String str1, String str2) {

        if(str1.length() == 0){
            return str1.length();
        }else if(str2.length() == 0){
            return str2.length();
        }

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i=str1.length()-1; i>=0; i--){
            for(int j=str2.length()-1; j>=0; j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j+1],Math.max(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        int temp = dp[0][0];
        return str1.length() + str2.length() - temp;
    }

    public static void main(String[] args) {
        String str1 = "brute";
        String str2 = "groot";
        System.out.println(smallestSuperSequence(str1,str2));
    }
}
