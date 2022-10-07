class MyCalendarThree {
    private Map<Integer, Integer> map;
    
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        // Attempt 1: comapre each start and end with every other start and end, results in a time complexity of n 
        // lets code it
        // time complexity: everytime we call 'book' we iterate through each booking, comparing it to our booking, thus where n is the amount of bookings, book() runs in O(n).
        // Note: ended up reading the question wrong, this solution fails when we reach a pair that overlaps with x timestamps, but only if we take into consideration multiple points of the pair.
        
        // Attempt 2: use a TreeSet and a tally to keep track of each index overlapping values 
        
        int curr = 0; 
        int highestVal = 0;
        
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        
        for(int val: map.values()) {
            curr += val;
            highestVal = Math.max(highestVal, curr);
        }
        return highestVal;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

