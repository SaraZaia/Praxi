//https://leetcode.com/problems/container-with-most-water/submissions/


class ContainerWithMostWater {
    int result = 0;
    
    //Optimised solution: the best solution is the one that cover the big area so start with all 
    public int maxArea(int[] height) {
        int pStart = 0;
        int pEnd = height.length - 1;
        int count = height.length - 1;
        int minHeight = 0;
        
        while(pStart < pEnd) {
            minHeight = Math.min(height[pStart], height[pEnd]);
            result = Math.max(result, minHeight * count);
            
            if(height[pStart] <= height[pEnd]) pStart++;
            else pEnd--;
            count--;
        }
        return result;
    }
    
    // Brute force solution
    public int maxArea(int[] height) {    
        int pStart = 0;
        int pEnd = 0;
        int count = 0;
        int min = 0;
        
        while(pStart < height.length) {
            pEnd = pStart;
            count = 0;
            
            while( pEnd < height.length-1) {
                pEnd++;
                count++;
                min = Math.min(height[pStart], height[pEnd]);
                result = Math.max( result, min * count);
            }
            pStart++;
        }
        return result;
    }
    
    
}
