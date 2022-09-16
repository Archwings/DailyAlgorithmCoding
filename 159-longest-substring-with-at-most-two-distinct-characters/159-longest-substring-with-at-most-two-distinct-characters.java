class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        if (n < 3) return n;
        
        int left = 0; 
        int right = 0;
        int longest = 2;
        
        // as long as were not at the end of the string
        while (right < n) {
            if (map.size() <= 2) {
                map.put(s.charAt(right), right++);
            }
            if (map.size() == 3){
                int lowestInd = Collections.min(map.values());
                map.remove(s.charAt(lowestInd));
                left = lowestInd+1;
            }
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}