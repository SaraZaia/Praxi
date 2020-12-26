//https://leetcode.com/problems/wiggle-sort-ii/

class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.sort(nums);
        
        
        int limit = nums.length / 2;
        if(nums.length % 2 != 0) limit++;
        int pMid = nums.length -1;
        int pStart = limit -1;
        int i = 0;
        while(pStart >=0 || pMid >= limit) {
            if(pStart >= 0) {
                result[i++] = nums[pStart--];
            }
            if(pMid >= limit) {
                result[i++] = nums[pMid--];
            }
        }
        i = 0;
        
        for(int x: result) nums[i++] = x;
        
    }
}
