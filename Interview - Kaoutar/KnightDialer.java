//https://leetcode.com/problems/knight-dialer/

class KnightDialer {
    
    Map<String, Integer> memo = new HashMap<>();
    int mod = 1000000007;
    long result = 0;
    
    public int knightDialer(int n) {
        String[][] matrix = new String[][]
        {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*", "0", "#"}};
        
        int solution;
        //Initial posoition for the chess knight
        for(int i=0; i <= 3; i++) {
            for(int j = 0; j <= 2; j++) {
                solution = dfs(matrix, n-1, new int[]{i,j});
                result += solution;
                result %= mod;
            }
        }
        int res = (int)(result % mod);
        return res;
    }
    
    
    public int dfs(String[][] matrix, int n, int[] position) {
        if(position[0] < 0 || position[0] > 3 || position[1] < 0 ||position[1] > 2 || matrix[position[0]][position[1]].equals("*") ||  matrix[position[0]][position[1]].equals("#") || n < 0)
                    return 0;
        
        if(memo.containsKey(position[0] +" - " + position[1] + " - " + n)) {
            return memo.get(position[0] +" - " + position[1] + " - " + n);
        }            
        
        if(n == 0 ) return 1;
        long solution = 0;
        
        if(position[0]+2 <= 3 && position[1]-1 >= 0 
           && !matrix[position[0]+2][position[1]-1].equals("*") && !matrix[position[0]+2][position[1]-1].equals("#")) 
            solution = solution + dfs(matrix, n-1, new int[]{position[0]+2, position[1]-1}); //2 up + 1Left
        
        if(position[0]+2 <= 3 && position[1]+1 <=2 
           && !matrix[position[0]+2][position[1]+1].equals("*") && !matrix[position[0]+2][position[1]+1].equals("#")) 
            solution = solution +  dfs(matrix, n-1, new int[]{position[0]+2, position[1]+1});   //2 up + 1right     
        
        if(position[0]-2 >= 0 && position[1]-1 >= 0 
           && !matrix[position[0]-2][position[1]-1].equals("*") && !matrix[position[0]-2][position[1]-1].equals("#"))         
            solution = solution + dfs(matrix, n-1, new int[]{position[0]-2, position[1]-1});    //2down + 1Left     
        
        if(position[0]-2>=0 && position[1]+1 <=2  
           && !matrix[position[0]-2][position[1]+1].equals("*") && !matrix[position[0]-2][position[1]+1].equals("#")) 
            solution = solution + dfs(matrix, n-1, new int[]{position[0]-2, position[1]+1});    //2down + 1Right       
        
        if(position[0]+1 <= 3 && position[1]-2 >= 0 
           && !matrix[position[0]+1][position[1]-2].equals("*") && !matrix[position[0]+1][position[1]-2].equals("#")) 
            solution = solution + dfs(matrix, n-1, new int[]{position[0]+1, position[1]-2}); //2 up + 1Left       
        
        if(position[0]+1 <=3 && position[1]+2 <= 2 
           && !matrix[position[0]+1][position[1]+2].equals("*") && !matrix[position[0]+1][position[1]+2].equals("#")) 
            solution = solution + dfs(matrix, n-1, new int[]{position[0]+1, position[1]+2});   //2 up + 1right     
        
        if(position[0]-1 >=0 && position[1]-2 >= 0 
           && !matrix[position[0]-1][position[1]-2].equals("*") && !matrix[position[0]-1][position[1]-2].equals("#")) 
            solution = solution + dfs(matrix, n-1, new int[]{position[0]-1, position[1]-2});    //2down + 1Left     
        
        if(position[0]-1 >=0 && position[1]+2 <= 2 
           && !matrix[position[0]-1][position[1]+2].equals("*") && !matrix[position[0]-1][position[1]+2].equals("#")) 
            solution = solution + dfs(matrix, n-1, new int[]{position[0]-1, position[1]+2});    //2down + 1Right  
        
        
        solution %= mod;
        memo.put(position[0] +" - " + position[1] + " - " + n, (int)solution);
        return (int)solution;
    }
}
