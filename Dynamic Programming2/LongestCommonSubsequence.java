//https://leetcode.com/problems/longest-common-subsequence/

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] tab = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) tab[i][j] = tab[i-1][j-1] + 1;
                else tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
            }
        }
        return tab[text1.length()][text2.length()]; 
    }
}
