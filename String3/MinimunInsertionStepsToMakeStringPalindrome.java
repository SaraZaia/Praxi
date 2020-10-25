//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

class MinimunInsertionStepsToMakeStringPalindrome {
    public int minInsertions(String s) {
        int pointerStart = 0;
        int pointerEnd = s.length() - 1;
        Map<String, Integer> memoization = new HashMap<>();
        
        return minInsertions(s, pointerStart, pointerEnd, memoization);

    }
    
    public int minInsertions(String s, int pStart, int pEnd, Map<String, Integer> memoization) {
        if(memoization.containsKey(pStart + " - " + pEnd)) return memoization.get(pStart + " - " + pEnd);
        
        if(pStart >= pEnd ) return 0; 
        if(s.charAt(pEnd) == s.charAt(pStart)) {
            memoization.put(pStart + " - " + pEnd, minInsertions(s, pStart+1, pEnd-1, memoization));
            return memoization.get(pStart + " - " + pEnd);
        } else{
            memoization.put(pStart + " - " + pEnd, 1 + Math.min(minInsertions(s, pStart+1, pEnd, memoization), minInsertions(s, pStart, pEnd-1, memoization)));
            return memoization.get(pStart + " - " + pEnd);
        }
    }
}
