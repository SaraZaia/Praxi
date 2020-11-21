//https://leetcode.com/problems/top-k-frequent-elements/

class topKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((Pair a, Pair b) -> a.count - b.count);
        
        for(int x: nums) countMap.put(x, countMap.getOrDefault(x,0) + 1);
        
        for(int x : countMap.keySet()) {
            pQueue.add(new Pair(x, countMap.get(x)));
            if(pQueue.size() > k ) pQueue.poll();
 
        }
        int[] result = new int[k];
        int i = 0;
        for(Pair p : pQueue) result[i++] = p.num; 
        
        return result;
    }
    
    
    class Pair{
        int num;
        int count;
        Pair(int n, int c) {
            num = n;
            count = c;
        }
    }
}
