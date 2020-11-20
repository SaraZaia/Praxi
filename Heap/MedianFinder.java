//https://leetcode.com/problems/find-median-from-data-stream/


// Use Two heaps: Max heap {1,3,5} and Min heap {7,9} ===> 5
// Max heap {1,3,5} and Min heap {7,9,12} ===> 5 + 7 / 2 = 6
class MedianFinder {
    
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    

    /** initialize your data structure here. */
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(!minQueue.isEmpty() &&  minQueue.peek() < num) minQueue.add(num);
        else if(!maxQueue.isEmpty() &&  maxQueue.peek() >= num) maxQueue.add(num);
        else minQueue.add(num);
        
        if(maxQueue.size() > minQueue.size() + 1) minQueue.add(maxQueue.poll());
        if(maxQueue.size() < minQueue.size()) maxQueue.add(minQueue.poll());

        
    }
    
    public double findMedian() {
        int n = minQueue.size() + maxQueue.size();
        double result;
        if(n == 0) result = 0;
        else if(n % 2 == 0) result = (maxQueue.peek() + minQueue.peek()) / 2.0;
        else result = maxQueue.peek() ;
        return result;       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */







//Using ArrayList + Insertion sort + Binary Search 
class MedianFinder {

    static List<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int n = list.size();
        if(n == 0) list.add(num);
        else if(num <= list.get(0)) list.add(0,num);
        else if(num >= list.get(n-1)) list.add(num);
        
        else {
            int pStart = 0;
            int pEnd = n - 1;
            int mid;
            //Binary search 
            while(pStart <= pEnd) {
                mid = pStart + (pEnd - pStart)/2;
                if(list.get(mid) <= num && list.get(mid+1) >= num) {
                    list.add(mid+1,num);
                    break;
                }
                else if(list.get(mid) >= num &&  list.get(mid-1) <= num) {
                    list.add(mid,num);
                    break;
                }
                else if(list.get(mid) >= num) pEnd = mid - 1;
                else pStart = mid;
            }
        }
    }
    
    public double findMedian() {
        int n = list.size();
        double result;
        if(n == 0) result = 0;
        else if(n % 2 == 0) result = (list.get(n / 2) + list.get((n/2) - 1)) / 2.0;
        else result = list.get(n / 2) ;
        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
