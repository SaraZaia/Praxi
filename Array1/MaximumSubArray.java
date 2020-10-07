//https://leetcode.com/problems/maximum-subarray/

class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int max = nums[0];
        if(n == 1) return max;
        int[] results = new int[n];
        
        results[0] = max;
        
        for(int j = 1; j < n; j++) {
            results[j] = results[j-1] + nums[j]; 
            if(max < results[j]) max = results[j];
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                results[j] = results[j] - nums[i]; 
                if(max < results[j]) max = results[j];
            }
        }
        return max;
    
    }
}
