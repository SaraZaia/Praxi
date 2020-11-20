//
//https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {

    PriorityQueue<Integer> minQueue;
    int capacity;
    
    public KthLargest(int k, int[] nums) {
        capacity = k;
        minQueue = new PriorityQueue<>();  
        int i = 0;
        while(i < nums.length && i < k) minQueue.add(nums[i++]);
        while(i < nums.length) {
            if(minQueue.peek() < nums[i]) {
                minQueue.poll();
                minQueue.add(nums[i]);
            }
            i++;
        }
    }
    
    public int add(int val) {
        if( minQueue.size() == capacity && minQueue.peek() < val) {
                minQueue.poll();
            minQueue.add(val);
        }
        else if(minQueue.size() < capacity) minQueue.add(val);
        return minQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
