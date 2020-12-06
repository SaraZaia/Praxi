//https://leetcode.com/problems/non-decreasing-array/

class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // add numbers in order
        int result = 0;
        
        int i = 0;
        while(i < nums.length) {
            
            if(stack.isEmpty() || stack.peek() <= nums[i]) {
                stack.add(nums[i]); // 
                i++;
            }
            else {
                // Action1: remove the previous number
                if(i+1 < nums.length && nums[i+1] < stack.peek())stack.pop();
                else i++; // or Action2: skip this number
                
                result++;// an action is done
            }
            if(result > 1) return false; // modifying at most 1 element
        }
        return true;
    }
}
