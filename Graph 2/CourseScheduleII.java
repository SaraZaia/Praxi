//https://leetcode.com/problems/course-schedule-ii/

class CourseScheduleII {
    
    Set<Integer> memoNode = new HashSet<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        List<Integer> temp;
        
        //Build Graph: From List of edge representation to Adjacency List graph representation
        for(int[] edge : prerequisites) {
            temp = adjacencyList.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[0]);
            adjacencyList.put(edge[1], temp);
        }
        for(int i = 0; i < numCourses; i++) 
            if(!adjacencyList.containsKey(i))
                 adjacencyList.put(i, null);

        
        //System.out.println(adjacencyList.toString());
        //is there cercle?
        for(int node = 0; node < numCourses; node++) {
            if(dfsCycle(adjacencyList, node, new HashSet<>())) return new int[0];
            memoNode.add(node);
        }
        
        //Topological sort
        
        
        return topSort(adjacencyList, numCourses);
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
    
    
    
    public int[] topSort(Map<Integer, List<Integer>> adjacencyList, int numCourses) {
        int index = numCourses-1;
        
        Set<Integer> visited = new HashSet<>();
        int[] result = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        
        int temp = 0;
        boolean last = true;
        
        for(int number: adjacencyList.keySet()) {
            if(!visited.contains(number)) stack.add(number);
            
            while(!stack.isEmpty()) {
                //for(int x: result) System.out.print(x + "  ");
                temp = stack.peek();
                //System.out.println("  Temp  = " + temp + "---------> Stack = " + stack.toString());
                last = true;
                if(adjacencyList.get(temp) != null) {
                    for(int x: adjacencyList.get(temp)) {
                        if(!visited.contains(x)) last = false;
                    }
                }
                
                if(adjacencyList.get(temp) == null || last) {
                    if(!visited.contains(temp)) result[index--] = temp;
                    visited.add(stack.pop());
                } else {
                    for(int x: adjacencyList.get(temp)) {
                        if(!visited.contains(x)) stack.add(x);
                    }
                }
            }
        }
        
        
        return result;
    }
    
    
    
}
