class MedianFinder {
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;
    
    public MedianFinder() {
        maxQ = new PriorityQueue<>((a, b) -> b - a);
        minQ = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if (maxQ.isEmpty() || num <= maxQ.peek()) {
            maxQ.add(num);
        } else {
            minQ.add(num);
        }
        
        // balance the PriorityQueues
        if (maxQ.size() > minQ.size() + 1) {
            minQ.add(maxQ.poll());
        } 
        if(minQ.size() > maxQ.size()) {
            maxQ.add(minQ.poll());
        }
    }
    
    public double findMedian() {
        if (maxQ.size() == minQ.size()) {
            return (double) (minQ.peek() + maxQ.peek())/2;
        } else {
            return (maxQ.peek());
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */