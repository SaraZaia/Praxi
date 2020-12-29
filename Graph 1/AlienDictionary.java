//https://leetcode.com/problems/alien-dictionary/


class AlienDictionary {
    public String alienOrder(String[] words) {
        
        // build graph
        Map<Character, Set<Character>> dictionary = new HashMap<>();
        
        boolean continueLoop = true;
        int k = 0;
        int indexI, indexJ;
        Set<Character> listChar;
        for(int i = 0; i <= words.length-1; i++) {
            if(k < words[i].length() && !dictionary.containsKey(words[i].charAt(k)))
                dictionary.put(words[i].charAt(k), null);
            while(i+1 < words.length && k < words[i].length() && k < words[i+1].length() && words[i].charAt(k) == words[i+1].charAt(k)) {
                if(!dictionary.containsKey(words[i].charAt(k))) dictionary.put(words[i].charAt(k), null);
                k++;
            }
            if(i+1 < words.length && k < words[i].length() && k >= words[i+1].length()) return "";
            if(i+1 < words.length && k < words[i].length() && k < words[i+1].length() && words[i].charAt(k) != words[i+1].charAt(k)) {
                listChar = dictionary.get(words[i].charAt(k)) == null? new HashSet<>(): dictionary.get(words[i].charAt(k));
                listChar.add(words[i+1].charAt(k));
                dictionary.put(words[i].charAt(k), listChar); 
            }
            
            indexI = k;
            indexJ = k;
            
            while(indexI < words[i].length()) {
                if(!dictionary.containsKey(words[i].charAt(indexI))) dictionary.put(words[i].charAt(indexI), null);
                indexI++;
            }
            while(i+1 < words.length && indexJ < words[i+1].length()) {
                if(!dictionary.containsKey(words[i+1].charAt(indexJ))) dictionary.put(words[i+1].charAt(indexJ), null);
                indexJ++;
            }
                
            k = 0;
        }

        System.out.println(dictionary.toString());

        if(isCycle(dictionary)) return "";
        return toplogicalSort(dictionary);
    }
    
    
    boolean isCycle(Map<Character, Set<Character> > dictionary ) {
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        Character tempChar = null;
        
        for(Character c: dictionary.keySet()) {
            stack.add(c);
            seen = new HashSet<>();
            while(!stack.isEmpty()) {
                tempChar = stack.pop();
                if(seen.contains(tempChar)) return true;
                seen.add(tempChar);
                if(dictionary.get(tempChar) != null)
                    for(Character chara: dictionary.get(tempChar)) {
                        stack.add(chara);
                    } 
                else {
                    seen.remove(tempChar);
                }
            }   
        } 
        return false;
    }
    
    
    
    
    String toplogicalSort(Map<Character, Set<Character> > dictionary ) {
        Set<Character> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        boolean last = true;
        
        Character temp = null;
        for(Character chara: dictionary.keySet()) {
            if(!visited.contains(chara)) stack.add(chara);
            
            outer: while(!stack.isEmpty()) {
                temp = stack.peek();
                last = true;
                if(dictionary.get(temp) != null ) 
                    for(char ca: dictionary.get(temp) ) 
                        if(!visited.contains(ca)) 
                            last = false;
                
                if(dictionary.get(temp) == null || last) {
                    visited.add(temp);
                    result.insert(0, stack.pop());
                    continue outer;
                }
                for(Character c: dictionary.get(temp)) {
                    if(!visited.contains(c)) stack.add(c);                
                }
            }
            
        }
        
        return result.toString();        
    }
}
