//https://leetcode.com/problems/find-peak-element/

class FindPeekElement {
    public int findPeakElement(int[] nums) {
        if(nums.length >1 && nums[0] > nums[1]) return 0;
        
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1] && nums[i] > nums[i-1] )
                return i;
        }
        return  nums.length-1;
    }
}
