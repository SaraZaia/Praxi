//https://leetcode.com/problems/delete-operation-for-two-strings/

class DeleteOperationForTwoStrings {

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
