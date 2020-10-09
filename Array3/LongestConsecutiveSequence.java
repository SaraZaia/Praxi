//https://leetcode.com/problems/longest-consecutive-sequence/

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        
        for(int x : nums) set.add(x);      
        
        int sum = 0;
        int a;
        
        for(int x : set) {
            a = x;
            if(!visited.contains(x)){
                sum = 0;
                while(set.contains(a)) {
                    sum++;
                    visited.add(a);
                    a = a + 1;

                }
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}
