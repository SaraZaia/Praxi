//https://leetcode.com/problems/minimum-cost-to-connect-sticks/

class MinimumCostToConnectStricks {
    public int connectSticks(int[] sticks) {
        if(sticks.length <= 1) return 0; 
        PriorityQueue<Integer> sticksQueue = new PriorityQueue<>();
        
        for(int x: sticks) sticksQueue.add(x);
        int sum = 0;
        int result = 0;
        while(sticksQueue.size() != 1) {
            sum = sticksQueue.poll() + sticksQueue.poll();
            sticksQueue.add(sum);
            result +=sum;
        }
        
        return result;
        
    }
}
