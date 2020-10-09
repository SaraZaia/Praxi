//https://leetcode.com/problems/majority-element/

class MajorityElement {

    /* Brute force
    
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.compute(nums[i], (k,v) ->(v == null)? 1 : v+1);
            if(map.get(nums[i]) > n)
                return nums[i];
        }
        return 0;
    } */
    
        public int majorityElement(int[] nums) {
            return majorityElementDivideConquer(nums, 0, nums.length-1);
        }
    
    
    public int majorityElementDivideConquer(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        int n = (end - start) / 2;
        if(start == end) return nums[start];
        
        int first = majorityElementDivideConquer(nums, start, mid);
        int second = majorityElementDivideConquer(nums, mid+1, end);
        
        int countFirst;
        int countSecond;
        
        if(first == second) return first;
        else {
            countFirst = count(nums, first, start, end);
            countSecond = count(nums, second, start, end);
            return countFirst > countSecond ? first : second;
        }
        
    }
    
    
    
    public int count(int[] nums, int k, int start, int end ) {
        int count = 0;
        for(int i = start; i <= end; i++) {
            if(nums[i] == k) count++;
        }
        return count;
    }

}
