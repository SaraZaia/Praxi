//https://leetcode.com/problems/edit-distance/

class EditDistance {
    
    Map<String, Integer> memo = new HashMap<>();
    // Recursion + memoization
    public int minDistanceRec(String word1, String word2) {
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
    
    //--------------------------------------------------------------------------------------------------------------
    // Edit distance algo Levenshtein 
    //https://medium.com/@ethannam/understanding-the-levenshtein-distance-equation-for-beginners-c4285a5604f0
    public int minDistance(String word1, String word2) {
        
        int[][] tab = new int[word1.length()+1][word2.length()+1];
        
        for(int i = 0; i <= word1.length(); i++) {
            for(int j = 0; j <= word2.length(); j++) {
                if(i == 0) tab[i][j] = j;
                if(j == 0) tab[i][j] = i;
            }
        }
        
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))                 
                    tab[i][j] = Math.min(tab[i-1][j-1], Math.min(tab[i][j-1] + 1, tab[i-1][j] + 1)); // if equals no replace => no (+1)
                else 
                    tab[i][j] = Math.min(tab[i-1][j-1] + 1, Math.min(tab[i][j-1] + 1, tab[i-1][j] + 1) );//Replace, delete, insert
            }
        }
        
        return tab[word1.length()][word2.length()];
    }
}
