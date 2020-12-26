//https://leetcode.com/problems/longest-string-chain/

class LongestStringChain {
    
    int result = 1;
    public int longestStrChain(String[] words) {
        Map<String, List<String>> adjacencyList = new HashMap<>();
        Arrays.sort(words, (String a, String b) -> b.length() - a.length());
        
        List<String> tempList;
        //Build Graph: Adjacency List
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(words[j].length() < words[i].length() - 1) break;
                if(words[j].length() == words[i].length() - 1 && isPredecessor(words[i], words[j])) {
                    tempList = adjacencyList.getOrDefault(words[i], new ArrayList<>());
                    tempList.add(words[j]);
                    adjacencyList.put(words[i], tempList);                    
                }
            }
        }
        
        //Graph DFS Traversal
        for(String s: adjacencyList.keySet()) {
            dfs(adjacencyList, s, 0);
        }
        
        return result;
    }
    
    
    
    public void dfs(Map<String, List<String>> adjacencyList, String s, int length) {
        if(adjacencyList.get(s) == null || adjacencyList.get(s).isEmpty()) {
            result = Math.max(result, length + 1);
            return;
        }
            
        for(String str : adjacencyList.get(s)) {
            dfs(adjacencyList, str, length + 1);
        }
    }
    
    
    public boolean isPredecessor(String word, String predecessor ) {
        int pWord = 0;
        int pPredecessor = 0;
        int diff = 0;
        
        while(pWord < word.length() && pPredecessor < predecessor.length()) {
            if(word.charAt(pWord) == predecessor.charAt(pPredecessor)) {
                pWord++;
                pPredecessor++;
            }
            else {
                pWord++;
                diff++;
            }
            if(diff > 1) return false;    
        }
        return diff == 1 || (diff == 0 && pPredecessor == predecessor.length());
    }
}

