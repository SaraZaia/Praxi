//https://leetcode.com/problems/minimum-size-subarray-sum/

class MinimumSizeSubarraySum{
    
    //Two pointer ================================================
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int count = Integer.MAX_VALUE;
        int pStart = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            while(sum >= s && pStart <= i) {
                count = Math.min(count, i - pStart+1);
                sum -= nums[pStart];
                pStart++;
            }
        }
        return count == Integer.MAX_VALUE ? 0: count;
    }
    
    
    //Memoization ===============================================
    
    Map<String, Integer> memo = new HashMap<>();
    public int minSubArrayLen2(int s, int[] nums) {

        int sum = 0;
        int result = 0;
        for(int x: nums) sum += x;
        if(sum < s) return 0;
        else {
            result = minSubArrayLen(s, nums, sum, 0 , nums.length - 1);
            return result == Integer.MAX_VALUE? 0 : result; 
        }
    }
    
    
    
    public int minSubArrayLen(int s, int[] nums, int sum, int pStart, int pEnd) {
        if(memo.containsKey(pStart + " - " + pEnd)) {
            System.out.println(pStart + " - " + pEnd +" = " + memo.get(pStart + " - " + pEnd));
            return memo.get(pStart + " - " + pEnd);
        }
        
        if(sum == s) {
            System.out.println("pStart = " + pStart + ", pEnd = " + pEnd + " =  " + (int)(pEnd - pStart + 1) );
            return pEnd - pStart + 1;
        }
        else if(sum < s) {
            System.out.println("pStart = " + pStart + ", pEnd = " + pEnd + " =  " + (int)(pEnd - pStart + 2)  );
            return pEnd - pStart + 2;
        }
        else if(pStart > pEnd) {
            System.out.println("pStart = " + pStart + ", pEnd = " + pEnd + " =  " + Integer.MAX_VALUE );
            return Integer.MAX_VALUE;
        }
            
        
        int result = Math.min(minSubArrayLen(s, nums, sum - nums[pEnd], pStart , pEnd-1), 
                        minSubArrayLen(s, nums, sum-nums[pStart], pStart+1 , pEnd));
        memo.put(pStart + " - " + pEnd, result);
        
        return result;
    }
    
}
