//https://leetcode.com/problems/jump-game/


class JumpGame {
    public boolean canJump(int[] nums) {
        return dp(nums, nums.length - 2, nums.length - 1);
    }
    
    
    public boolean dp(int[] nums, int position, int target) {
        if(position < 0 && target > 0) return false;
        if(target == 0) return true;
        
        if(nums[position] >= target - position) return dp(nums, position - 1, position);
        else return dp(nums, position - 1, target);   
    }
}
