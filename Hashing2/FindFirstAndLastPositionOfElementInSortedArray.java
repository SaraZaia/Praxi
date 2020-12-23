//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/

class FindFirstAndLastPositionOfElementInSortedArray {
    
    public int[] searchRangeBinarySearch(int[] nums, int target) {
        
        int pStart = 0;
        int pEnd = nums.length - 1;
        int mid;
        int[] result = new int[]{-1,-1};

        
        while (pStart <= pEnd) {
            mid = pStart + (pEnd - pStart)/2;

            if(result[0] == -1) {
                if(nums[mid] == target && (mid == 0 || nums[mid-1] < target)) {
                    result[0] = mid;
                    result[1] = mid;
                    pStart = mid + 1;
                    pEnd = nums.length - 1;
                }
                else if(nums[mid] < target) pStart = mid + 1;
                else pEnd = mid-1;
            } else {
                if(nums[mid] == target && (mid == nums.length-1 || nums[mid+1] > target)) {
                    result[1] = mid;
                    break;
                }
                else if(nums[mid] == target) pStart = mid + 1;
                else pEnd = mid - 1;                
            }
        }

        return result;
    }
    
    
    
    public int[] searchRange(int[] nums, int target) {
        
        int pStart = 0;
        int pEnd = nums.length - 1;
        int mid;
        int[] result = new int[]{-1,-1};

        
        while (pStart < pEnd) {
            mid = pStart + (pEnd - pStart)/2;

           if(nums[mid] > target) {
                pEnd = mid;
                
            } 
            else if(nums[mid] < target) {
                pStart = mid+1;
            }
            else if( nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                
                pStart = mid-1;
                pEnd = mid+1;
                
                while (pStart >= 0 && nums[pStart] == target){
                        result[0] = pStart;
                        pStart--;
                }

                while (pEnd <nums.length && nums[pEnd] == target){
                        result[1] = pEnd;
                        pEnd++;
                }
                break;
            }
            
        }
        if(pStart == pEnd && nums[pStart] ==target) {
            result[0] = pStart;
            result[1] = pEnd;
        }
        return result;
        
        
    }
}
