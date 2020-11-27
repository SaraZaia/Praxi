class LCS_String {

    
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
                    tab[i][j].x = tab[i-1][j-1].x + 1;
                    tab[i][j].sb.append(tab[i-1][j-1].sb.toString()).append(word2.charAt(j-1));
                    
                }
                else {
                    if(tab[i][j-1].x >= tab[i-1][j].x) {
                        tab[i][j].x = tab[i][j-1].x;
                        tab[i][j].sb.append(tab[i][j-1].sb.toString());

                    } else {
                        tab[i][j].x = tab[i-1][j].x;
                        tab[i][j].sb.append(tab[i-1][j].sb.toString());
					}
                }
            }            
        }
        
        
        return tab[word1.length()][word2.length()].sb.toString();
    }
    
    
    
    static class Pair{
        int x;
        StringBuilder sb;
        
        Pair() {
            this.x = 0;
            this.sb = new StringBuilder();
        }
        
        Pair(int x, String s) {
            this.x = x;
            this.sb = new StringBuilder();
            this.sb.append(s);
        }
    
    }
}
