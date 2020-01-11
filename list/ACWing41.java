class MinStack {

    private Stack<Integer> A;
    private Stack<Integer> B;

    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    
    public void push(int x) {
        A.push(x);
        if (B.isEmpty()) B.push(x);
        else B.push(Math.min(B.peek(), x));
    }
    
    public void pop() {
        A.pop();
        B.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int getMin() {
        return B.peek();
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
