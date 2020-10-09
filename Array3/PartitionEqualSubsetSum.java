//https://leetcode.com/problems/partition-equal-subset-sum/

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length - 1;
        int sum = 0;
        int max = nums[0];
        
        for(int x : nums) {
            sum += x;
            if(x > max) max = x;
        }
        if(sum % 2 != 0) return false;
        int avr = sum / 2;
        
        if(max > avr) return false;
        
        // look for list sum == avr
        
        return dfs(nums, n, avr);
    }
    
    public boolean dfs(int[] nums, int n, int avr ) {
        if(avr == 0) return true;
        if(n == 0 || avr < 0) return false;
        
        return dfs(nums, n-1, avr - nums[n-1]) || dfs(nums, n-1, avr);     
    }
    
}
