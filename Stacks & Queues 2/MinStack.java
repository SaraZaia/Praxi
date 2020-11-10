//https://leetcode.com/problems/min-stack/

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() { }
    
    public void push(int x) {
        int min = minStack.isEmpty() ? Integer.MAX_VALUE: minStack.peek();
        this.stack.push(x);
        this.minStack.push(Math.min(x,min));
        
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
