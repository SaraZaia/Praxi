//https://leetcode.com/problems/k-closest-points-to-origin/

class kClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        //Max Heap
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((Pair a, Pair b) -> Double.compare(b.distance, a.distance));
        
        
        for(int[] point : points) {
            pQueue.add(new Pair(point));
            if(pQueue.size() > k ) pQueue.poll();
 
        }
        int[][] result = new int[k][2];
        int i = 0;
        for(Pair p : pQueue) result[i++] = p.point; 
        
        return result;
    }
    
    
    class Pair{
        int[] point;
        double distance;
        
        Pair(int[] n) {
            point = new int[]{n[0],n[1]};
            distance = Math.sqrt(Math.pow(n[0],2) + Math.pow(n[1],2));
        }
    }
}
