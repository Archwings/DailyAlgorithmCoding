class StockSpanner {
    // Use a stack to determine the count of previous prices. For each call to next, while the previous stacks price is less than or equal to the current price, then add it to the answer. If we reach a price that is greater than the current price. push the current count and price onto the stack
    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
        // [0] - is the count [1] - is the price
        Stack<int[]> stack = new Stack<>();
    }
    
    public int next(int price) {
        int result = 1;
        while(!stack.isEmpty() && stack.peek()[1] <= price) {
            result += stack.pop()[0];
        } 
        stack.push(new int[]{result, price});
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */