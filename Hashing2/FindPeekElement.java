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
    
    
    public int findPeakElementBinarySearch(int[] nums) {
        if(nums.length >1 && (nums[0] > nums[1])) return 0;
        if(nums.length >1 && ( nums[nums.length-1] > nums[nums.length-2] )) return nums.length-1;
        
        int pStart = 1;
        int pEnd = nums.length-2;
        int mid = 0;
        while( pStart <= pEnd ) {
            mid = pStart + (pEnd - pStart ) / 2;
            
            if(nums[mid] > nums[mid-1] && nums[mid+1] < nums[mid] ) return mid;
            if(nums[mid] > nums[mid-1]) pStart = mid + 1;
            else pEnd = mid - 1;
        }
        return 0;
    }
}
