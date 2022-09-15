class Solution {
    public int[] findOriginalArray(int[] changed) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(changed);
        if (changed.length % 2 == 1) {
            return new int[] {};
        }
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i ++) {
            map.put(changed[i], map.getOrDefault(changed[i],0)+1);
        }
        
        
        for (int i = 0; i < changed.length; i ++) {
            if (map.containsKey(changed[i]) && map.get(changed[i]) > 0) {
                if (map.containsKey(changed[i] *2) && map.get(changed[i]*2) > 0){
                    map.put(changed[i], map.getOrDefault(changed[i], 0)-1);
                    map.put(changed[i]*2, map.getOrDefault(changed[i]*2, 0)-1);
                    //if (!list.contains(changed[i])) {
                        
                    //}
                    list.add(changed[i]);
                } else {
                    return new int[] {};
                }
            }
        }
        
        
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        
        return arr;
    }
}