//https://leetcode.com/problems/friend-circles/

class FriendCircles {
    public int findCircleNum(int[][] M) {
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < M.length; i++) {
            if(!visited.contains(i)) {
                getCercle(M, i, visited);
                result++;
            }
        }
       return result; 
    }
    
    public void getCercle(int[][] M, int startLine, Set<Integer> visited) {        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startLine);
        int line;
        
        while(!queue.isEmpty()) {
            line = queue.poll();
            for(int i = 0; i < M[0].length; i++) {
                if(M[line][i] == 1 && !visited.contains(i)) {
                    queue.add(i);
                }
            }
            visited.add(line);
        }
    }
}
