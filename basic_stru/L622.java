class MyCircularQueue {

    private int capacity;
    private int[] arr;
    private int tail = -1;
    private int head = 0;
    private int count = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.arr = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (count >= capacity) return false;

        tail = (tail + 1) % capacity;
        arr[tail] = value;
        count++;

        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (count == 0) return false;

        head = (head + 1) % capacity;
        count--;

        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (count == 0) return -1;

        return arr[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (count == 0) return -1;

        return arr[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
