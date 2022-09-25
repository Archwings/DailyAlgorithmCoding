class MyCircularQueue {
    private LinkedList<Integer> queue;
    private int size;
    private int currSize;

    public MyCircularQueue(int k) {
        // Initialize the qeuue, we will do this by using a LinkedList data structure
        this.queue = new LinkedList<Integer>();
        this.size = k;
        this.currSize = 0;
        
    }
    
    public boolean enQueue(int value) {
        if (this.currSize >= this.size) {
            return false;
        } else {
            this.queue.add(value);
            currSize++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if (this.queue.isEmpty()) {
            return false;
        } else {
            this.queue.removeFirst();
            this.currSize--;
            return true;
        }
    }
    
    public int Front() {
        if (!this.queue.isEmpty()) {
            return this.queue.getFirst();
        } else {
            return -1;
        }
    }
    
    public int Rear() {
        if (!this.queue.isEmpty()) {
            return this.queue.getLast();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
    
    public boolean isFull() {
        return (this.size == this.currSize);
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