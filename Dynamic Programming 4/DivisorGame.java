//https://leetcode.com/problems/divisor-game/

class DivisorGame {
    
    public boolean divisorGame(int N) {
        boolean result = false;
        
        while(N > 1) {
            N = N - firstDiv(N);
            result = !result;
        }
        return result;
    }
    
    //
    public int firstDiv(int N) {
        int d = 1;
        while(N % d != 0) d++;
        System.out.println(N + " - " + d + " = " +(int)(N-d));
        return d;
    }
}
