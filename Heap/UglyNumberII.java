//https://leetcode.com/problems/ugly-number-ii/

class Ugly {
    
    int[] uglyNumber = new int[1691];
    
    Ugly() {
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        
        pQueue.add(1L);
        int[] primes =new int[]{2,3,5};
        
        int count = 1;
        long curr;
        
        while (count <= 1690) {
            curr = pQueue.poll();
            uglyNumber[count++] = (int)curr;
            
            for(int x : primes){
                if(!visited.contains(curr * x)) {
                    pQueue.add(curr * x);
                    visited.add(curr * x);
                }
            }
            
        }
    }
}



class UglyNumberII {
    
    static Ugly u = new Ugly();
    
    public int nthUglyNumber(int n) {
        return u.uglyNumber[n];
    }
}
