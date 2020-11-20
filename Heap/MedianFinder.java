//https://leetcode.com/problems/find-median-from-data-stream/


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
