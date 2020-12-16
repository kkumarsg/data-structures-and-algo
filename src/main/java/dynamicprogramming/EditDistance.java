package dynamicprogramming;

import java.util.Map;

public class EditDistance {

    /*
    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

    You have the following three operations permitted on a word:Insert,Delete,Replace a character

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
     */

    /*
    Plain recursion
     */
    public int editDistance(String s1, String s2, int m, int n){
        if(m==0) return n;
        if(n==0) return m;

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return editDistance(s1,s2,m-1,n-1);
        }
        return 1+
                Math.min
                        (Math.min
                                (editDistance(s1,s2,m-1,n),editDistance(s1,s2,m,n-1)
                                ),editDistance(s1,s2,m-1,n-1)
                        );
    }

    /*
        recursion with memoization
     */
    public int editDistance(String s1, String s2, int m, int n, Map<String, Integer> map){
        if(m==0) return n;
        if(n==0) return m;

        String key = m+"-"+n;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return editDistance(s1,s2,m-1,n-1,map);
        }
        int res = 1 +
                Math.min
                        (Math.min(editDistance(s1,s2,m-1,n,map),editDistance(s1,s2,m,n-1,map))
                                ,editDistance(s1,s2,m-1,n-1,map)
                        );
        map.put(key, res);
        return res;
    }

    /*
        Edit distance DP.
     */
    public int editDistanceDp(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=n; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }

        return dp[m][n];
    }


}
