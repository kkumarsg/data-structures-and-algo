package dynamicprogramming;

public class LongestCommonSubSequenceDp {

    /*
      * The idea is simple, in the second approach we are doing top down calculations. Now we shall do bottom up.
      *
      *
      *         ""   B    A    Z
      *       --------------------
      *    "" |  0 | 0  | 0  | 0 |
      *     A |  0 | 0  | 1  | 1 |        READ DIAGONALLY WHEN LAST CHARACTERS ARE SAME + 1
      *     X |  0 | 0  | 1  | 1 |        READ FROM MAX OF LAST ADJACENT VALUES.
      *     Y |  0 | 1  | 1  | 1 |
      *     Z |  0 | 0  | 1  | 2 |
      *       --------------------
      *
     */

    public int lcs(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<s1.length()+1; i++){
            for(int j=1; j<s2.length()+1; j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
