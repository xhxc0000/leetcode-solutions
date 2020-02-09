class MyQueue {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) stackB.push(stackA.pop());
        }
        return stackB.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) stackB.push(stackA.pop());
        }
        return stackB.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
