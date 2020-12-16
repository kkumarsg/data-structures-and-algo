package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSequence {

    /*
        Method 1 : using LCS we can find lis. Sort the array and find the lcs with itself to get lis.
     */
    public int lengthOfLISUsingLCS(int[] nums) {

        int[] sorted = Arrays.copyOf(nums,nums.length);
        Arrays.sort(sorted);

        return lcs(nums, Arrays.stream(sorted).distinct().toArray());

    }

    public static int lcs(int[] s1, int[] s2){
        int[][] dp = new int[s1.length+1][s2.length+1];

        for(int i=1; i<s1.length+1; i++){
            for(int j=1; j<s2.length+1; j++){
                if (s1[i-1]==s2[j-1] ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }


    /*
        Method 2: we find lis for every element. In other words lis when we include the element.
        lis[i] = [max of lis[all i's less than i. and nums[i's]<nums[i])
     */
    public int lengthOfLISDp(int[] nums) {

        int[] lis = new int[nums.length];
        int maxlis = 1;
        lis[0] = 1;
        for(int i=1; i<nums.length; i++){
            lis[i] = findLisAtI(nums, lis, i);
            maxlis = Math.max(maxlis, lis[i]);
        }
        return maxlis;
    }

    public int findLisAtI(int[] nums, int[] lis, int i){
        int maxlis = 0;
        for(int j=0; j<i; j++){
            if(nums[j]<nums[i]){
                maxlis = Math.max(maxlis, lis[j]);
            }
        }
        return maxlis+1;
    }

    /*
        Method 3: Using patience sort algo, O(nlogn)
     */
    public static int lengthOfLIS(int[] nums) {

        int[] tail = new int[nums.length];
        Arrays.fill(tail,-111);
        tail[0] = nums[0];
        int lastIndexTail = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>tail[lastIndexTail-1]){
                tail[lastIndexTail] = nums[i];
                lastIndexTail += 1;
            }
            else{
                int c = findCeilIndex(tail, nums[i], 0, lastIndexTail-1);
                tail[c] = nums[i];
            }
        }
        return lastIndexTail;
    }

    public static int findCeilIndex(int[] numbers, int number, int start, int end){
        int middle = start + (end-start)/2;
        if(numbers[middle]>=number && (middle==0 || numbers[middle-1]<number)){
            return middle;
        }
        if(numbers[middle]>number){
            return findCeilIndex(numbers, number, start, middle-1);
        }
        return findCeilIndex(numbers, number, middle+1, end);
    }

}
