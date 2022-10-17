class Solution {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            map.put((char)('a' + i) , 0);
        }
        
        for(int i = 0; i < sentence.length(); i++) {
            int count = map.getOrDefault(sentence.charAt(i), 0);
            map.put(sentence.charAt(i), count+1);
    
        }
        
        for(int value: map.values()) {
            if (value < 1) {
                return false;
            }
        }
        return true;
            
    }
}