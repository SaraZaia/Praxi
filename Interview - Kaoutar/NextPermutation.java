//https://leetcode.com/problems/next-permutation/

class NextPermutation {
    public void nextPermutation(int[] nums) {
        
        int start = -1;
        int end = nums.length-1;
        outer: for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i-1] < nums[i]) {
                start = i-1;
                for(int j = start+1; j < nums.length; j++) {
                    if(nums[start] < nums[j]) {
                        end = j;
                    } else {
                        break outer;
                    }
                }
                break;
            }
        }         
        swap(nums, start, end);
        reverse(nums, start+1);
        
    }
    
    public void swap(int[] nums, int start, int end ) {
        if(start != -1) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
    
    
    public void reverse(int[] nums, int start) {        
        int pStart = start;
        int pEnd = nums.length-1;
        
        while(pStart < pEnd) {
            swap(nums, pStart, pEnd);
            pStart++;
            pEnd--;
        }        
    }
}
