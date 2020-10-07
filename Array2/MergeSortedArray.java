//https://leetcode.com/problems/merge-sorted-array/

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        
        int endNUMS2 = n - 1;
        int endNUMS1 = m - 1;
        
        while(endNUMS1 >=0 && endNUMS2 >= 0)
            nums1[k--] = nums1[endNUMS1]<nums2[endNUMS2]? nums2[endNUMS2--] : nums1[endNUMS1--] ; 
        
        for(int i = k; endNUMS2>=0 && i >=0; i--) {
            nums1[i] =  nums2[endNUMS2--];
        }
        
    }
}
