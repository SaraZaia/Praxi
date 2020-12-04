//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

class LongestIncreasingPathInMatrix {
    
    int[][] memo;
    int result = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        memo = new int[matrix.length][matrix[0].length];
        int[][] seen = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                memo[i][j] = dfs(matrix ,i ,j ,seen, Integer.MAX_VALUE);  
                result = Math.max(result, memo[i][j]);
            }
        }
        return result;
    }
    
    
    int dfs(int[][] matrix, int i,int j ,int[][] seen, int previous) {
        int count;
        int left=0, down=0, up=0, right=0;

        if( i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || seen[i][j] != 0 
           || (previous != Integer.MAX_VALUE && previous <= matrix[i][j])) {
            return 0;   
        }
        
        if(memo[i][j] != 0) {
            return memo[i][j];
        }
        
        if (i >= 0) {
            seen[i][j] = -1;
            left = 1 + dfs(matrix, i-1, j, seen, matrix[i][j]);
            seen[i][j] = 0;
        }
        if (j >= 0) {
            seen[i][j] = -1;
            up = 1 + dfs(matrix, i, j-1, seen,  matrix[i][j]);
            seen[i][j] = 0;
        }
        if (i < matrix.length) {
            seen[i][j] = -1;
            right = 1 + dfs(matrix, i+1, j, seen,  matrix[i][j]);
            seen[i][j] = 0;
        }
        if (j < matrix[0].length) {
            seen[i][j] = -1;
            down = 1 + dfs(matrix, i, j+1, seen, matrix[i][j]);
            seen[i][j] = 0;
        }
        return Math.max(Math.max(left,right), Math.max(up, down));
    }
}
