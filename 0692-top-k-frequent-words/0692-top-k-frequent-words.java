class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int length = words.length;
        for (int i = 0; i < length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        
        TreeMap<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
            
            @Override
            public int compare(String s1, String s2) {
                int comp = (map.get(s2) - map.get(s1));
                if (comp == 0) {
                    return s1.compareTo(s2);
                }
                return comp;    
            }
        });
        treeMap.putAll(map);
        List<String> list = new ArrayList<>();
        
        for(String s: treeMap.keySet()) {
            if (k > 0){
                list.add(s);
                k--;
            } else {
                return list;
            }
        }
        //System.out.println(treeMap.values());
        return list; 
    }
}