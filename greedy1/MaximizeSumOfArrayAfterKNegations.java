//https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int index = 0;
        int sum = 0;
        //if list of contains negatives values: choose the max values possible to return them positives 
        while(index < A.length && A[index] < 0 && K > 0) {
            A[index] = A[index] * -1;
            K--;
            index++;
        }
        Arrays.sort(A);
        index = 0;
        //if list of positive values: choose the min multiple times 
        if(index < A.length && A[index] >= 0 && K > 0 && K % 2 != 0) {
            A[index] = A[index] * -1;
        }        
        
        for(int x: A) sum += x;
        
        return sum;
    }
}
//[-4,-3,-2]
// 4 + 2 + 3 = 9 
// 2


//[2,-3,-1,5,-4]
//[-4,-3,-1,2,5]
// k = 2
//4 + 3 - 1 + 2 + 5 = 13


//[2,3,4], k = 1
// 4 + 3 + 2 
// if all positive and k % 2 == 0 =>Sum
// if all positive and k % 2 != 0 =>min * -1


//if negative =>from min to max 

// if nrgative + positive


//we change k + we compare 


    
