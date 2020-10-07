//https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1

class SwappingPairsMakeSumEqual
{
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
}
