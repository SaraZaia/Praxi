//https://leetcode.com/problems/subarray-sum-equals-k/
class SubbarrauSumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] results = new int[n];
        int sum = 0;
        
        results[0] = nums[0];
        if(nums[0] == k) sum++;
        
        for(int j = 1; j < n; j++) {
            results[j] = results[j-1] + nums[j]; 
            if(k == results[j]) sum++;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                results[j] = results[j] - nums[i]; 
                if(k == results[j]) sum++;
            }
        }
        return sum;
        
    }
}
