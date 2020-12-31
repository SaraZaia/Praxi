//https://leetcode.com/problems/single-element-in-a-sorted-array/

class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        
        int pStart = 0;
        int pEnd = nums.length - 1;
        int mid = 0;
        
        while(pStart <= pEnd) {
            
            mid = pStart + (pEnd - pStart) / 2;
            if((mid == 0 || nums[mid] != nums[mid-1] ) && (mid == nums.length - 1 || nums[mid] != nums[mid+1] ))
                return nums[mid];
            
            else if((mid-1 >= 0 && nums[mid] != nums[mid-1] && mid % 2 != 0) || (mid+1 < nums.length && nums[mid] != nums[mid+1] && mid % 2 == 0)   )
                pEnd = mid - 1;
            else 
                pStart = mid + 1;
        }
        return -1;
    }
}


//[1,1,2,3,3,4,4,8,8]
//[0,1,2,3,4,5,6,7,8]

/*

even number => the second element  in the left



*/
