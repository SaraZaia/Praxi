//https://leetcode.com/problems/path-with-maximum-gold/

// DFS + Backtracking
class PathWithMaximumGold {
    
    int solution = 0;
    public int getMaximumGold(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        
        int[][] seen = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) bfs(grid, seen, i, j, 0);
            }
        }
        
        return solution;
    }
    
    
    
    int  bfs(int[][] grid, int[][] seen, int i, int j, int sol) {
        
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || seen[i][j] == -1) {
            solution = Math.max(solution, sol);
            return sol;
        }
        sol += grid[i][j];

        if(i <= grid.length-1 ) {
            seen[i][j] = -1;
            bfs(grid, seen, i+1, j, sol);
            seen[i][j] = 0;
        }
        if(j <= grid[0].length-1) {
            seen[i][j] = -1;
            bfs(grid, seen, i, j+1, sol);
            seen[i][j] = 0;
        }
        if(i >= 0)  {
            seen[i][j] = -1;
            bfs(grid, seen, i-1, j, sol);
            seen[i][j] = 0;
        }
        if(j >= 0)  {
            seen[i][j] = -1;
            bfs(grid, seen, i, j-1, sol);
            seen[i][j] = 0;
        }
        return sol;
    }
}
