//https://leetcode.com/problems/subarray-sums-divisible-by-k/

class SubarraySumsDivisibleByK {

    //Brute force solution
    public int subarraysDivByK(int[] A, int K) {
        int sumDiv = 0;
        
        int[] result = new int[A.length];
        result[0] = A[0];
        if(result[0] % K == 0) sumDiv++;
        System.out.println(A[0]);

        
        for(int i = 1; i < A.length; i++) {
            result[i] = A[i] + result[i-1];
            if(result[i] % K == 0) sumDiv++;
            System.out.println(result[i]);
        }
        
        System.out.println("-----------------------");

        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length; j++) {
                result[j] = result[j] - result[i];
                if(result[j] % K == 0 ) sumDiv++;
                System.out.println(result[j]);

            }
            System.out.println("-----------------------");

        }
        return sumDiv;        
    }
}
