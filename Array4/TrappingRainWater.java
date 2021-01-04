//https://leetcode.com/problems/trapping-rain-water/

class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        int result = 0;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int j = height.length-1;
        for(int i = height.length-1; i>=0; i--) {
            leftMax = Math.max(leftMax, height[j-i]);
            rightMax = Math.max(rightMax, height[i]);
            
            leftMaxArr[j-i] = leftMax;
            rightMaxArr[i] = rightMax;
        }
        
        for(int i = 0; i < height.length; i++) {
            result += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return result;
    }
}
