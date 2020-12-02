//https://leetcode.com/problems/longest-continuous-increasing-subsequence/

class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int sol = 0;
    
        for(int i = 0; i < nums.length; i++) {
            
            if(i == 0 || nums[i-1] < nums[i]) sol++;
            else {
                result = Math.max(result, sol);
                sol = 1;
            }
        }
        result = Math.max(result, sol);
        return result;
    }
}
