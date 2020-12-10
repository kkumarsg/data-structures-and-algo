package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequence {

    /*
        * Approach 1: Layman approach
     */
    public int longestCommonSubsequence(String s1, String s2) {

        int lcs = 0;
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            int index = s2.indexOf(ch);
            if(index!=-1){
                lcs = Math.max(lcs,
                        1+longestCommonSubsequence(s1.substring(i+1), s2.substring(index+1)));
            }
        }
        return lcs;
    }
    /*
     * Approach 1: Layman approach, let's memoize :D
     */

    Map<String, Integer> map = new HashMap<>();
    public int longestCommonSubsequenceMem(String s1, String s2) {
        if(map.containsKey(s1+s2)){
            map.get(s1+s2);
        }
        int lcs = 0;
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            int index = s2.indexOf(ch); // This is where complexity is hammered again.
            if(index!=-1){
                lcs = Math.max(lcs,
                        1+longestCommonSubsequenceMem(s1.substring(i+1), s2.substring(index+1)));
            }
        }
        map.put(s1+s2,lcs);
        return lcs;
    }

    /*
        * Approach 2: Slightly better.
     */

    public int lcs(String s1, String s2, int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1+lcs(s1,s2,m-1,n-1);
        }
        else{
            return Math.max(lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
        }
    }

    /*
     * Approach 2: Slightly better, Let's use matrices :D
     * We can show that the complexity of approach 2 is O(mn) since every entry in the table is populated only once.
     */

    int[][] mem; // this is filled with 0's.
    public int lcsMem(String s1, String s2, int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        if(mem[m][n]!=0) {
            return mem[m][n] - 1;
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            mem[m][n] =  1+lcsMem(s1,s2,m-1,n-1) ;
        }
        else{
            mem[m][n] = Math.max(lcsMem(s1,s2,m-1,n),lcsMem(s1,s2,m,n-1)) ;
        }
        mem[m][n] += 1; // adding this since lcs can be zero, in that case we're populating lcs as 1.
        return mem[m][n]-1;
    }


}
