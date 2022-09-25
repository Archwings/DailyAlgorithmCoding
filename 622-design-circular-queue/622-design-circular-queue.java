class MyCircularQueue {
    LinkedList<Integer> queue;
    int size;
    int currSize;

    public MyCircularQueue(int k) {
        // Initialize the qeuue, we will do this by using a LinkedList data structure
        queue = new LinkedList<Integer>();
        size = k;
        currSize = 0;
        
    }
    
    public boolean enQueue(int value) {
        if (currSize >= size) {
            return false;
        } else {
            queue.add(value);
            currSize++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if (queue.isEmpty()) {
            return false;
        } else {
            queue.removeFirst();
            currSize--;
            return true;
        }
    }
    
    public int Front() {
        if (!queue.isEmpty()) {
            return queue.getFirst();
        } else {
            return -1;
        }
    }
    
    public int Rear() {
        if (!queue.isEmpty()) {
            return queue.getLast();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public boolean isFull() {
        return (size == currSize);
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