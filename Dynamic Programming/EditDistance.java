//https://leetcode.com/problems/edit-distance/


class EditDistance {
    
    Map<String, Integer> memo = new HashMap<>();
    public int minDistance(String word1, String word2) {
        
        
        return dp(word1, word2, word1.length()-1, word2.length()-1);
        
    }
    
    public int dp(String word1, String word2, int pW1, int pW2) {
        
        if(memo.containsKey(pW1 + " - " + pW2)) return memo.get(pW1 + " - " + pW2);
        
        if(pW2 < 0) return pW1+1;
        if(pW1 < 0) return pW2+1;
        
        int result = 0;
        if(word1.charAt(pW1) == word2.charAt(pW2)) {
            result = dp(word1, word2, pW1 - 1, pW2-1);
            memo.put(pW1 + " - " + pW2, result);
            return result; 
        }
        else {
            result = Math.min(1+ dp(word1, word2, pW1, pW2 - 1), // insert
                        Math.min(1+ dp(word1, word2, pW1-1, pW2), 1+ dp(word1, word2, pW1 - 1, pW2-1))); //delet, replace
            memo.put(pW1 + " - " + pW2, result);
            return result;
        }
    }   
}
