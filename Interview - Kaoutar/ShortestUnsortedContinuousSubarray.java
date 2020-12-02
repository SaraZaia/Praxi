//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

class ShortestUnsortedContinuousSubarray {
    
    
    //Sort => {SpaceComplexity : O(n), TimeComplexity : O(nlog(n))}
    public int findUnsortedSubarrayNlogN(int[] nums) {
        int[] sorted = new int[nums.length];
        sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        
        int pStart = 0;
        int pEnd = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != sorted[i]) {
                pStart = i;
                break;
            }
        }
        for(int i = nums.length-1; i >=0; i--) {
            if(nums[i] != sorted[i]) {
                pEnd = i;
                break;
            }
        }
        
        return pEnd - pStart == 0?0: pEnd - pStart + 1;
    }
    
    //Stack => {SpaceComplexity : O(n), TimeComplexity : O(n)}
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> sort = new Stack<>();
        
        int start = 0;
        int end = 0;
        boolean go = true;
        
        for(int x: nums) {
            if(go && (sort.isEmpty() || sort.peek() <= x)) {
                sort.add(x);
            } else if(!sort.isEmpty() && sort.peek() > x) {
                while(!sort.isEmpty() && sort.peek() > x) sort.pop();
                go = false;
            }
            start = sort.size();
        }
        
        if(sort.size() == nums.length) return 0;
        go = true;
        sort.clear();
        for(int i = nums.length-1; i >=0; i--) {
            if(go && (sort.isEmpty() || sort.peek() >= nums[i])) {
                sort.add(nums[i]);
            } else if(!sort.isEmpty() && sort.peek() < nums[i]) {
                while(!sort.isEmpty() && sort.peek() < nums[i]) sort.pop();
                go = false;
            }
            end = nums.length - 1 - sort.size();
        }  
        System.out.println(start);
        System.out.println(end);
        
        
        return  end - start + 1;
    }
}
