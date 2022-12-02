class Solution {
    public boolean closeStrings(String word1, String word2) {
        // create a hash by getting the count of each character in the string. Sort the hash in increasing order. If both hash for word1 == word2, we return true and athe strings are "close"
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for (char c: word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0)+1);    
        }
        
        for (char c: word2.toCharArray()) {
            if (!map1.containsKey(c)) {
                return false;
            }
            map2.put(c, map2.getOrDefault(c, 0)+1);    
        }
        
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        
        while(iterator1.hasNext()) {
            int val1 = iterator1.next();
            int val2 = iterator2.next();
            if(val1 == val2) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}