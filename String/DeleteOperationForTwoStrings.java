//https://leetcode.com/problems/delete-operation-for-two-strings/

class DeleteOperationForTwoStrings {
    
    
    //Dynamic Programming
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int lcs = 0;
        
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1)== word2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                System.out.println("word1 " + word1.charAt(i-1) + " word2 " + word2.charAt(j-1)+ " == " +dp[i][j]);
            }
            System.out.println(" --------------------------------- ");
        }
        lcs = dp[word1.length()][word2.length()];
        return word1.length() -2*lcs + word2.length();
    }

    //DFS without memorisation
    public int minDistance(String word1, String word2) {
        
        int lcs = lcs(word1, word2, 0, 0);
        System.out.println(lcs);
        
        return word1.length() -2*lcs + word2.length();
    }
    //LongestCommon subsequence
    public int lcs(String s1, String s2,int indexS1, int indexS2) {
        
        if(indexS1 >= s1.length() || indexS2 >= s2.length()) return 0;
        
        if(s1.charAt(indexS1) == s2.charAt(indexS2))
            return 1 + lcs(s1, s2, indexS1 + 1, indexS2+1);
        
        return Math.max(lcs(s1, s2, indexS1 + 1, indexS2), lcs(s1, s2, indexS1 , indexS2+1));
    }
}
