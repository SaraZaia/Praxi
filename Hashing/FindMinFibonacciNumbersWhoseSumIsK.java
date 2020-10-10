//https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

class FindMinFibonacciNumbersWhoseSumIsK {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibonacciNumbers = fibonacciNumbers(k);
        System.out.println(fibonacciNumbers.toString());
        
        return findMinFibonacciNumbers(fibonacciNumbers, k, fibonacciNumbers.size()-1);
    }
    
    
    //Every positive integer can be written as a sum of Fibonacci number using a number once
    //So we get the max near the k, and we look for findMinFibonacciNumbers for the "rest"
    public int findMinFibonacciNumbers(List<Integer> fibonacciNumbers, int k, int position) {
        int sum = 0;
        while(position > 0 && fibonacciNumbers.get(position) > k){
            position--;
        }
        if(fibonacciNumbers.get(position) == k) return 1;
        else return 1 + findMinFibonacciNumbers(fibonacciNumbers, k-fibonacciNumbers.get(position), position);
    }

    
    //Generate the Fibonacci Numbers until the k
    public List<Integer> fibonacciNumbers(int k) {
        List<Integer> result = new ArrayList<>();
        result.add(1);   
        result.add(1);
        int n = 2;
        
        while( result.get(n-1) <= k) {
            result.add(result.get(n-1)+result.get(n-2));
            n = result.size();
        }
        return result;
    }

    
    
}
