//https://leetcode.com/problems/find-all-duplicates-in-an-array/

class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        int i = 0;
        
        while(i < nums.length) {
            while(nums[i] != i+1) {
                if(nums[nums[i]-1] == nums[i]) {
                    if(!result.contains(nums[i])) result.add(nums[i]);
                    break;
                }
                else if(nums[nums[i]-1] != nums[i]) swap(i, nums[i]-1, nums);
            }
            i++;
        }   
        return new ArrayList<Integer>(result);
    }
    
    
    void swap(int position1, int position2, int[] nums) {
        int temp = nums[position1];
        nums[position1] = nums[position2];
        nums[position2] = temp;
    }
}
