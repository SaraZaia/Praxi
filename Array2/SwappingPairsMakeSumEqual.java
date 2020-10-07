//https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1

class SwappingPairsMakeSumEqual
{
    //Using SET<Integer> to look for 2 numbers in A and B, that the difference is equal to diffAtoB
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        Set<Long> setA = new HashSet<>();
        for(long x : A) setA.add(x);
        long sumA = 0;
        long sumB = 0;
        
        for(long x : A) {
            sumA +=x;
        }
        for(long x : B) {
            sumB +=x;
        }
        long avg = (sumA+sumB) / 2;
        long diffAtoB = avg - sumA;
        
        for(long x: B) if(setA.contains(x + diffAtoB )) return 1;
        return 0;
    }
    
    //Using sort to look for 2 numbers in A and B, that the difference is equal to diffAtoB
    long findSwapValuesSort(long A[], int n, long  B[], int m)
    {
        long sumA = 0;
        long sumB = 0;
        
        for(long x : A) {
            sumA +=x;
        }
        for(long x : B) {
            sumB +=x;
        }
        long avg = (sumA+sumB) / 2;
        long diffAtoB = avg - sumA;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int startA = 0;
        int endB = m-1;
        while(startA<n && endB >=0) {
            if( A[startA] + diffAtoB < B[endB]) startA++;
            else if( A[startA] + diffAtoB > B[endB]) endB--;
            else return 1;
            
        }
        return 0;
    }
}
