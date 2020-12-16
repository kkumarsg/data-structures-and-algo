package dynamicprogramming;

import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println("findNoOfWays(coins, 6) = " + findNoOfWays(coins, 13));
        System.out.println("findNoOfWaysNonDulicate(coins, 6) = " + findNoOfWaysNonDuplicate(coins, 6,0));
        System.out.println("findNoOfWaysBetterRecursion(coins,6,3) = " + findNoOfWaysInDpAssistWay(coins, 6, 3));
    }

    public int findNoOfWaysDp(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if ((i - coins[j - 1]) >= 0) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }
        return dp[amount][n];
    }

    public static int findNoOfWaysMemo(int[] numbers, int sum, int start, Map<String, Integer> map){
        if(sum<0 || start>=numbers.length){
            return 0;
        }
        if(sum==0){
            return 1;
        }
        String key = sum+"-"+start;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int ways =  findNoOfWaysMemo(numbers, sum-numbers[start],start, map)
                + findNoOfWaysMemo(numbers, sum,start+1, map);
        map.put(key, ways);
        return ways;
    }

    public static int findNoOfWaysInDpAssistWay(int[] numbers, int sum, int n){
        if(sum<0 || n==0){
            return 0;
        }
        if(sum==0){
            return 1;
        }
        return findNoOfWaysInDpAssistWay(numbers, sum-numbers[n-1],n)
                + findNoOfWaysInDpAssistWay(numbers, sum,n-1);
    }

    public static int findNoOfWaysNonDuplicate(int[] numbers, int sum, int start){
        if(sum<0){
            return 0;
        }
        if(sum==0){
            return 1;
        }
        int noOfWays = 0;
        /*
            [1,2,3] with 6.
            first call tries to find out ways we can make 6 by always including 1.
            second call tries to find out ways we can make 6 by always including 2 (but not 1)
            third call tries to find out ways we can make 6 by always including 3 (but not 1 and 2)
         */
        for(int i=start; i<numbers.length; i++){
            noOfWays += findNoOfWaysNonDuplicate(numbers, sum-numbers[i],i);
        }
        return noOfWays;
    }

    /*
    This returns duplicates
     */
    public static int findNoOfWays(int[] numbers, int sum){
        if(sum<0){
            return 0;
        }
        if(sum==0){
            return 1;
        }
        int noOfWays = 0;
        for(int i=0; i<numbers.length; i++){
            noOfWays += findNoOfWays(numbers, sum-numbers[i]);
        }
        return noOfWays;
    }
}
