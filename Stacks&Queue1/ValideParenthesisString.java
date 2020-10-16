//https://leetcode.com/problems/valid-parenthesis-string/

class ValideParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();
        
        boolean s1 = true;
        boolean s2 = true;
        boolean s3 = true;
        
        
        for(char c : s.toCharArray()) {
            if(c == '(' ) {
                stack1.add(c);
                stack2.add(c);
                stack3.add(c);
            }
            else if( c == ')'){
                if(!stack1.isEmpty()) stack1.pop(); 
                else s1 = false;
                if(!stack2.isEmpty()) stack2.pop(); 
                else s2 = false;
                if(!stack3.isEmpty()) stack3.pop();
                else s3 = false;
            } else if( c == '*') {
                stack1.add('(');
                if(!stack3.isEmpty()) stack3.pop();
                else s3 = false;

            }
        }
        
        if(!s1 && !s2 && !s3) return false;
        return stack3.isEmpty() || stack3.isEmpty() || stack3.isEmpty();
        
    }
}
