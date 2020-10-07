//https://leetcode.com/problems/k-diff-pairs-in-an-array/

class KdiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        Set<Pair> result = new HashSet<>();
        Map<Integer, Integer> numsSet = new HashMap<>(); // Value and index
        
        int i = 0;
        for(int x : nums) numsSet.put(x, i++);
        
        i = 0;
        for(int x : nums) {
            if(x == x+k && i == numsSet.get(x+k))
            if(numsSet.containsKey(x+k)) {
                if(x != x+k || i != numsSet.get(x+k)) // Not the same Number in the same position
                    result.add(new Pair(Math.min(x,x+k),Math.max(x,x+k)));
            }
            if(numsSet.containsKey(x-k)){
             if(x != x-k || i != numsSet.get(x-k))   
                result.add(new Pair(Math.min(x,x-k),Math.max(x,x-k)));
            }
            i++;
        }
        
        for(Pair x : result) System.out.println(x.x + "   " + x.y);

        return result.size();
    }
    
    static class Pair{
        int x;
        int y;
        Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
        
        
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            
            Pair p = (Pair) o;
            return x == p.x && y == p.y;
            
        }
        
        
        @Override
        public int hashCode(){
            return x*1000 + y;
        }
    }
}
