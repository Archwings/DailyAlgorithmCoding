class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create a hash function for each string component, if the next string component hash is the same as a previous, find the index and place it in the output array;
        int length = strs.length;
        
        // instead of a hash function, create a unique list of counts of each string

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int[] stringCount = new int[26];
            for (char c: strs[i].toCharArray()) {
                stringCount[c - 'a']++;
            }
            if (map.containsKey(Arrays.toString(stringCount))) {
                map.get(Arrays.toString(stringCount)).add(strs[i]);
            } else {
                map.put(Arrays.toString(stringCount), new ArrayList<String>(Arrays.asList(strs[i])));
            }
            
        }
        return new ArrayList(map.values());
        
    }
}