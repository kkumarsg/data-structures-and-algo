package dynamicprogramming;

public class MemiozationTopDown {


    int[] memo = new int[100]; // size will be dynamic based on input.

    /*
        We assume that all the values in memo are initialized to -1.
     */

    public int findFibonacci(int n){
        if(memo[n]==-1){
            if(n==0 || n==1){
                memo[n] = 1;
                return memo[n];
            }
            memo[n] = memo[n-1]+memo[n-2];
            /*
             This is top down approach, ie f(5) and f(4) are not ready while f(6) is being calculated.
             However, they're memorized once calculated.
             */
        }
        return memo[n];
    }
}
