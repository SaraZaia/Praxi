//https://leetcode.com/problems/unique-paths/

// Recursion + memoization
//---------------------------------------------------
    Map<String, Integer> tab = new HashMap<>();
    public int uniquePaths(int m, int n) {
        if(tab.containsKey(Math.min(m,n) + " - " + Math.max(m,n))) 
            return tab.get(Math.min(m,n) + " - " + Math.max(m,n));
        if(n==1 || m==1) return 1; 
        int result = uniquePaths(m-1, n) + uniquePaths(m, n-1);
        tab.put(Math.min(m,n) + " - " + Math.max(m,n), result);
        return result;
    }

// Tabulation
//--------------------------------------------------------------------------------
    
    public int uniquePathsTabulation(int line, int col) {
        int[][] tab = new int[line][col];
        
        for(int i = 0; i < line; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 || j == 0) tab[i][j] = 1;
                else tab[i][j] = tab[i-1][j] + tab[i][j-1];
            }
        }
     return tab[line-1][col-1];
    }

}                                                                           
