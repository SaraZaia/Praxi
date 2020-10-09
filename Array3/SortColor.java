//https://leetcode.com/problems/sort-colors/
class SortColor {
    public void sortColors(int[] nums) {
        int n = nums.length - 1;
        int indexStart = 0;
        int indexEnd = n;
        int i = 0;
        while(i <= indexEnd) {
            if(nums[i] == 0) {
                swap(nums, i, indexStart);
                indexStart++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums, i, indexEnd);
                indexEnd--;
            } else{
                i++;
            }
        }
    }
    
    
    public void swap(int[] nums, int iOne, int iTwo) {
        int temp = nums[iOne];
        nums[iOne] = nums[iTwo];
        nums[iTwo] = temp;
    }
}
