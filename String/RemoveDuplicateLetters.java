//https://leetcode.com/problems/remove-duplicate-letters/

class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int indexOrder = 0;
        Map<Character, Integer> countSort = new TreeMap<>();
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()) countSort.put(c, countSort.getOrDefault(c,0) + 1);
        
        outer: for(Character c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.add(c);
                visited.add(c);
                countSort.put(c, countSort.get(c) - 1);
            }
            else if(!visited.contains(c)){
                if(c.compareTo(stack.peek()) > 0 || countSort.get(stack.peek())+1<=1) {
                    stack.add(c);
                    visited.add(c);
                    countSort.put(c, countSort.get(c) - 1);
                    continue outer;
                }
                while(!stack.isEmpty() && c.compareTo(stack.peek()) < 0 && countSort.get(stack.peek())+1>1 ) {
                    visited.remove(stack.pop());
                }
                stack.add(c);
                visited.add(c);
                countSort.put(c, countSort.get(c) - 1);

            } else {
                countSort.put(c, countSort.get(c) - 1);                
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c: stack) sb.append(c);
        
        return sb.toString();       
        
    }
}
