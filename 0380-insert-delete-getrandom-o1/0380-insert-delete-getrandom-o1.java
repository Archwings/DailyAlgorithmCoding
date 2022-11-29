class RandomizedSet {
    // key = value: val = index
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, map.size());
            list.add(list.size(), val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastElement = list.get(map.size() - 1);
            list.set(index, lastElement);
            map.put(lastElement, index);
            
            // delete last element
            list.remove(list.size() - 1);
            map.remove(val);
            
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
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