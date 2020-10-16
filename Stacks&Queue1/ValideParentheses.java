//https://leetcode.com/problems/valid-parentheses/


class ValideParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(brackets.containsKey(c))
                stack.add(c);
            else{
                if(!stack.isEmpty() && brackets.get(stack.peek()) == c) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
