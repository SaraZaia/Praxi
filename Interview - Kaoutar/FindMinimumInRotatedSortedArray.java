//

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int pStart = 1;
        int pEnd = nums.length - 1;
        int mid = 0;
        if(nums[0] <= nums[nums.length-1]) return nums[0];
        
        while(pStart <= pEnd ) {
            
            mid = pStart + (pEnd - pStart) / 2;
            
            if(nums[mid] < nums[mid-1]) return nums[mid];
            else if(nums[nums.length-1] < nums[mid] ) pStart = mid + 1;
            else pEnd = mid - 1;            
        }
        return 0;
    }
}
