//https://leetcode.com/problems/sort-array-by-parity/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int pStart = 0;
        int pEnd = A.length - 1;
        int temp;
        
        while( pStart < pEnd) {
            if(A[pStart] % 2 == 0) pStart++;
            if(A[pEnd] % 2 != 0 ) pEnd--;
            
            else if(A[pStart] % 2 != 0 && A[pEnd] % 2 == 0) {
                temp = A[pStart];
                A[pStart] = A[pEnd];
                A[pEnd] = temp;
                pStart++;
                pEnd--;
            }
            
        }
        return A;
    }
}
