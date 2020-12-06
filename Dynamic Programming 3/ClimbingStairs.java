//https://leetcode.com/problems/climbing-stairs/

class ClimbingStairs{
    Map<Integer, Integer> solutions = new HashMap<>();
    
    public int climbStairs(int n) {
        if(solutions.containsKey(n)) return solutions.get(n);
        if(n == 0) return 1;
        if(n < 0) return 0;
        int result = climbStairs(n-1) + climbStairs(n-2);
        solutions.put(n, result);
        return result;
    }
}
