class MaxStack {
    TreeSet<int[]> stack;
    TreeSet<int[]> values;
    int cnt;
    
    public MaxStack() {
        Comparator<int[]> comp = (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        };
        stack = new TreeSet<>(comp);
        values = new TreeSet<>(comp);
        cnt = 0;
    
    }
    
    public void push(int x) {
        stack.add(new int[] {cnt, x});
        values.add(new int[] {x, cnt});
        
        cnt++;
    }
    
    public int pop() {
        int[] val = stack.pollLast();
        values.remove(new int[] {val[1], val[0]});
        
        return val[1];
    }
    
    public int top() {
        int[] val = stack.last();
        return val[1];
    }
    
    public int peekMax() {
        int[] val = values.last();
        return val[0];
    }
    
    public int popMax() {
        int[] val = values.pollLast();
        stack.remove(new int[] {val[1], val[0]});
        
        return val[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */