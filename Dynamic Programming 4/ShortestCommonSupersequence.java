//https://leetcode.com/problems/shortest-common-supersequence/

class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        return LCS(str1, str2);
    }
    
    
    public String LCS(String word1, String word2) {
        Pair[][] tab = new Pair[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0; i <= word1.length(); i++) {
            for(int j = 0; j <= word2.length(); j++) {    
                tab[i][j] = new Pair();
            }
        }
        
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    tab[i][j].countLCS = tab[i-1][j-1].countLCS + 1; // count LCS
                    
                    tab[i][j].scs.append(tab[i-1][j-1].scs.toString()).append(word2.substring(tab[i-1][j-1].pW2, j-1)); // Adding letter between two equals values
                    tab[i][j].scs.append(word1.substring(tab[i-1][j-1].pW1, i-1));                                     // For Word1 and Word2
                    tab[i][j].scs.append(word2.charAt(j-1));
                    
                    tab[i][j].pW1 = i;
                    tab[i][j].pW2 = j; //Indexes to add from after
                    
                }
                else {
                    if(tab[i][j-1].countLCS >= tab[i-1][j].countLCS) {
                        tab[i][j].countLCS = tab[i][j-1].countLCS;
                        tab[i][j].scs = tab[i][j-1].scs;
                        tab[i][j].pW1 = tab[i][j-1].pW1;
                        tab[i][j].pW2 = tab[i][j-1].pW2;

                    } else {
                        tab[i][j].countLCS = tab[i-1][j].countLCS;
                        tab[i][j].scs = tab[i-1][j].scs;
                        tab[i][j].pW1 = tab[i-1][j].pW1;
                        tab[i][j].pW2 = tab[i-1][j].pW2;
					}
                }
            }            
        }
        
        tab[word1.length()][word2.length()].scs.append(word2.substring(tab[word1.length()][word2.length()].pW2, word2.length()));
        tab[word1.length()][word2.length()].scs.append(word1.substring(tab[word1.length()][word2.length()].pW1, word1.length()));
        
        return tab[word1.length()][word2.length()].scs.toString();
    }
    
    
    
    static class Pair{
        int countLCS;
        StringBuilder scs;
        int pW1;
        int pW2;
        
        Pair() {
            this.countLCS = 0;
            this.scs = new StringBuilder();
            pW1 = 0;
            pW2 = 0;
        }
    }
}
