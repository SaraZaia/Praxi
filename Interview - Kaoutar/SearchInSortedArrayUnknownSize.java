//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchInSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int pStart = 0;
        int pEnd = getEndIndex(reader, target);
        int mid = 0;
        
        while(pStart <= pEnd) {
            mid = pStart + (pEnd - pStart) / 2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target) pStart = mid + 1;
            else pEnd = mid - 1;
        }
        return -1;
    }
    
    public int getEndIndex(ArrayReader reader, int target) {
        
        int index = 1;
        
        while(reader.get(index) != 2147483647) {
            index *= 2;
        }
        int pStart = index / 2;
        int pEnd = index -1;
        int mid = 0;
        
        while(pStart <= pEnd) {
            mid = pStart + (pEnd - pStart) / 2;
            if(reader.get(mid) != 2147483647 && reader.get(mid+1) == 2147483647)
                return mid;
            else if(reader.get(mid) == 2147483647) pEnd = mid - 1;
            else pStart = mid + 1;
        }
        return mid;
    }
}
