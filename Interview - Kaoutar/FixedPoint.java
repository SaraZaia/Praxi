//https://leetcode.com/problems/fixed-point/

class FixedPoint {
    public int fixedPoint(int[] A) {
        int pStart = 0;
        int pEnd = A.length - 1;
        int mid = 0;
        int result = -1;
        
        while(pStart <= pEnd) {
            mid = pStart + (pEnd - pStart) / 2;
            
            if(mid == A[mid]) result = mid;
            if(mid <= A[mid]) pEnd = mid - 1;
            else pStart = mid + 1;
        }
        return result;
    }
}
