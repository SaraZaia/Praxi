//https://leetcode.com/problems/sliding-window-maximum/

class SlidingWindowMaximum {
    
    //Complexity O(Nlog(k))
    public int[] maxSlidingWindowNlogK(int[] nums, int k) {
        PriorityQueue<Integer> windowMax = new PriorityQueue<>(Collections.reverseOrder());
        
        int[] result = new int[nums.length - k +1];
        
        for(int i  = 0; i <= nums.length - k; i++) {
            for( int j = 0; i == 0 && j < k; j++) windowMax.add(nums[j]);
            
            if(i != 0) {
                windowMax.add(nums[i + k -1]);
                windowMax.remove(nums[i - 1]);
            } 
            System.out.println(windowMax.toString());
            result[i] = windowMax.peek();
        }
        return result;
    }
    
    
    
    //Complexity O(N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] leftMax = new int[nums.length];    
        int[] rightMax = new int[nums.length];    
        int[] result = new int[nums.length-k+1];    
        
        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        
        int indexRight = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            if(i % k == 0) maxL = Integer.MIN_VALUE;
            if((indexRight + 1) % k == 0) maxR = Integer.MIN_VALUE;
            
            maxL = Math.max(maxL, nums[i]);
            maxR = Math.max(maxR, nums[indexRight]);
            leftMax[i] = maxL;
            rightMax[indexRight] = maxR;
        
            indexRight--;
        }
                
        int index = 0;
        for(int x: leftMax) {
            result[index] = Math.max(leftMax[index+k-1], rightMax[index]);
            index++;
            if(index >= result.length) break;
        }
        
        return result;
    }
    

}
