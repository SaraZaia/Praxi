//https://leetcode.com/problems/distribute-candies/submissions/

class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int n = candies.length / 2;
        // Return n/2 the max diff num 
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int x : candies) map.put(x, map.getOrDefault(x,0)+1);
        
        int diff = map.size();
        
        return diff > n ? n : diff;
        
    }
}
