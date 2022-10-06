class TimeMap {
    HashMap<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            List<Pair<String, Integer>> list = map.get(key);
            
            //dont sort if you dont have to
            // Collections.sort(list, new Comparator<Pair<String, Integer>>(){
            //          public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2){
            //              return p2.getValue() - p1.getValue();
            //          }});
            
            // perform binary search
            int left = 0;
            int right = list.size();
            // binary search on the list
            while(left < right) {
                int middle = (right+left)/2;
                // needs equals? why because we want the right pointer to always be to the right of the timestamp we want, if we use just '>' the right pointer will be equal to mid pointer which can lead to the right pointer pointing to the index we want
                if (timestamp >= list.get(middle).getValue()) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            // if nothing is found 
            if (right == 0) {
                return "";
            }
            return list.get(right-1).getKey();
        } else {
            return "";
        }
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */