//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        
        for(int x: nums) {
            if(nums[Math.abs(x) - 1] > 0) nums[Math.abs(x) - 1] *= -1;
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) result.add(i+1);
        }
        return result;
        
    }
}
