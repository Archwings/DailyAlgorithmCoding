class RandomizedSet {
    HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        Iterator iterator = set.iterator();
        int size = set.size();
        Random rand = new Random();
        int randNum = rand.nextInt(size);
        
        int count = 0;
        while (iterator.hasNext() && count <= size) {
            Object val = iterator.next();
            if(count == randNum) {
                return (Integer) val;
            }
            count++; 
        }
        return 0;
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */