//https://leetcode.com/problems/next-greater-element-i/

class NextGreaterElement {




    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        
        int x;
        int max = Integer.MAX_VALUE;
        outer: for(int i = 0; i < nums1.length; i++) {
            x = nums1[i];
            for(int y : nums2) {
                if(x == y) {
                    max = x;
                } 
                if(max == x && y > x) {
                    result[i] = y;
                    continue outer;
                }
                
            }
            
            max = Integer.MAX_VALUE;
        }
        return result;
    }
}
