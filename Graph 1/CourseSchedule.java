//https://leetcode.com/problems/course-schedule/

class CourseSchedule {
    
    Set<Integer> memoNode = new HashSet<>(); //Memoization
    
    // Solution: Graph + DFS + Backtracking
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        List<Integer> temp;
        
        //Build Graph: From List of edge representation to Adjacency List graph representation
        for(int[] edge : prerequisites) {
            temp = adjacencyList.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[0]);
            adjacencyList.put(edge[1], temp);
        }
        
        //is there cercle?
        for(int node: adjacencyList.keySet()) {
            if(dfsCycle(adjacencyList, node, new HashSet<>())) return false;
            memoNode.add(node);
        }
        return true;
    }
    
    public boolean dfsCycle(Map<Integer, List<Integer>> adjacencyList, int startNode, Set<Integer> visited) {
        if(memoNode.contains(startNode)) return false; // Memoization => path from this node already checked and no cercle 
        if(visited.contains(startNode)) return true; //In the same path we visit the same node twice => CERCLE
        if(adjacencyList.get(startNode) == null) return false; // End of the path
        
        for(int node: adjacencyList.get(startNode)) {
            visited.add(startNode);
            if(dfsCycle(adjacencyList, node, visited)) return true;
            visited.remove(startNode); // Backtrack
        }
        return false;
    }
    
}
