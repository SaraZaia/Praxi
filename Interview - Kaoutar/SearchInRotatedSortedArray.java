//https://leetcode.com/problems/search-in-rotated-sorted-array/

class SearchInRotatedSortedArray {
    
    public int search(int[] nums, int target) {
        int len = nums.length-1;
        int pivot = searchPivot(nums);
        
        if(target == nums[len]) return len;
        if(target < nums[len])
            return binarySearch(nums, target,pivot+1 , len);
        else 
            return binarySearch(nums, target, 0, pivot);
    }
    
    public int binarySearch(int[] nums, int target, int pStart, int pEnd) {
        int mid;
        while(pStart <= pEnd) {
            mid = pStart + (pEnd-pStart) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target){
                pStart = mid + 1;
            } else pEnd = mid - 1;
        }
        return -1;
    }    
    
    public int searchPivot(int[] nums) {
        if(nums.length <= 1) return 0;
        int maxList2 = nums[nums.length-1];
        int pStart = 0;
        int pEnd = nums.length-1;
        int mid;
        while(pStart <= pEnd) {
            mid = pStart + (pEnd-pStart) / 2;
            
            if(nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < maxList2) { //we are on the second sorted list => Left 
                pEnd = mid - 1;
            } else {
                pStart = mid + 1;
            }
        }
        return -1;
    }
    
}
/*[2, 5, 7, 8, 16, 18, 21, 34, 35, 39, 42, 51, 75, 84, 85, 86, 88, 91, 102]



[ 18, 21, 34, 35, 39, 42, 51, 75, 84,           85,          86,     88, 91, 102,      2,       5, 7, 8, 16]   num = 34
   0   1   2   3   4   5   6   7   8             9           10      11  12  13      14        15 16  17 18

19 / 2 = 9
18 - 10 / 2 = 10 + 4 
13 - 10 / 2 = 11


maxList2 = 16
minList1 = 18

85 < 16 ==> First part is sorted -> Right

14 < 16 ==>Second Part is sorted -> Left*/

