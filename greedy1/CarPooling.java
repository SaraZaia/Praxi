//https://leetcode.com/problems/car-pooling/

class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int currCapacity = 0; 
             
        Arrays.sort(trips, (int[] a, int[] b) -> a[1] - b[1]);
        System.out.println(Arrays.deepToString(trips));
        
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((int[] a, int[] b) -> a[2] - b[2]);
        
        int index = 0;
        
        while(index < trips.length ) {            
            while(!pQueue.isEmpty() && trips[index][1] >= pQueue.peek()[2]) currCapacity -= pQueue.poll()[0];
            
            currCapacity += trips[index][0];
            System.out.println(" CurrCapacity " + currCapacity);

            pQueue.add(trips[index]);
            
            if(currCapacity > capacity) return false;
            index++;
        }
        
        return true;
    }
}

//startLocation -> EndLocation
// capacity

//Sort by start Location 
//[[3,2,7],[3,7,9],[8,3,9]]
//[[3,2,7],[8,3,9],[3,7,9]] cap = 11
//[3,2,7]
//[11,2,9]
