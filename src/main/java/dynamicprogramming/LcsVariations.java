package dynamicprogramming;

public class LcsVariations {

    /*
                    ----------------
                    CONVERT S1 TO S2
                    ----------------
        * Min operations required to convert string s1 to s2.
        * Idea is to find lcs which gives the set of common values, and calculate the remaining items.
     */
    public int minOperations(String str1, String str2)
    {
        // Your code goes here
        int lcs = LongestCommonSubSequenceDp.lcs(str1, str2);
        return str1.length()-lcs+str2.length()-lcs;
    }

    /*
                -------------------------------
                LONGEST PALINDROMIC SUBSEQUENCE
                -------------------------------
         * We reverse the given string s1.
         * we find the lcs of s1 and reverse(s1).
         * This gives required answer. Since common sequences in s1 and reverse(s1) are palindromes.
     */
    public int longestPalindromicSubSequence(String s1){
        return LongestCommonSubSequenceDp.lcs(s1, new StringBuffer(s1).reverse().toString());
    }

    /*
                ------------------------
                PRINT LCS OF TWO STRINGS
                ------------------------

     */
    public String printLcs(String s1, String s2){
        return LongestCommonSubSequenceDp.getLcsString(s1,s2);
    }

    /*
                ------------------------------
                SHORTEST COMMON SUPER SEQUENCE
                ------------------------------

          * First we find the lcs of two strings, then we add the missing items in place.


          NOTE : You can also modify the printLcs method to give back shortest common super sequence.
     */
    public String shortestCommonSupersequence(String s1, String s2) {
         String lcs = LongestCommonSubSequenceDp.getLcsString(s1,s2);

         StringBuilder newLcs = new StringBuilder();
         for(int i=0; i<lcs.length(); i++){
             int index1 = s1.indexOf(lcs.charAt(i));
             int index2 = s2.indexOf(lcs.charAt(i));
             if(index1>=0){
                 for(int j=0; j<index1; j++){
                     newLcs.append(s1.charAt(j));
                 }
                 s1 = s1.substring(index1+1);
             }
             if(index2>=0){
                 for(int j=0; j<index2; j++){
                     newLcs.append(s2.charAt(j));
                 }
                 s2 = s2.substring(index2+1);
             }
             newLcs.append(lcs.charAt(i));
         }
         newLcs.append(s1).append(s2);

         return newLcs.toString();
    }

    /*
            -----------------------------
            LONGEST REPEATING SUBSEQUENCE
            -----------------------------

            * Wait.. If we find lcs of a string with itself, I should get all subsequences right ?
            * Yes, we do get all subsequences, and they are all common.
            * But if we ignore the ones which are at the same index, then we're done.
            * When we do the above step, we get the subsequence which are common between a string and itself(but aren't starting with same index)
                  Oh oh! That's awesome :D. Because that's what we wanted!

     */
    public int longestRepeatingSubsequence(String s1){
        int[][] dp = new int[s1.length()+1][s1.length()+1];

        for(int i=1; i<s1.length()+1; i++){
            for(int j=1; j<s1.length()+1; j++){
                if(s1.charAt(i-1)==s1.charAt(j-1) && (i!=j)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s1.length()];
    }
}
