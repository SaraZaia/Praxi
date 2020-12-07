//https://leetcode.com/problems/find-k-closest-elements/

class FindKclosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        int moveRight = 1;
        int moveLeft = 1;
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(arr[index]);
System.out.println(index);
        while(deque.size() < k) {
            if ( index - moveRight >= 0  
                &&( index + moveLeft >= arr.length || Math.abs(arr[index - moveRight]-x) <= Math.abs(arr[index + moveLeft]-x))) 
                deque.addFirst(arr[index - moveRight++]);

            else if ( index + moveLeft < arr.length 
                                     &&(index - moveRight < 0 || Math.abs(arr[index - moveRight]-x) > Math.abs(arr[index + moveLeft]-x)))
                deque.addLast(arr[index + moveLeft++]);
        }
        return new ArrayList<>(deque);
    }
    
    int binarySearch(int[] arr, int x) {
        int pStart = 0;
        int pEnd =arr.length - 1;
        int mid;
        
        if(x <= arr[0]) return 0;
        if(x >= arr[arr.length-1]) return arr.length-1;
        
        while(pStart <= pEnd) {
            mid = pStart + (pEnd - pStart) /2;
            if(arr[mid] == x || (arr[mid] <= x && arr[mid+1]>=x)) {
                if(Math.abs(arr[mid]-x) <= Math.abs(arr[mid+1]-x)) return mid;
                else return mid+1;
            }
            if(arr[mid] < x) pStart = mid + 1;
            else pEnd = mid - 1;
        }
        return 0;
    }
}
