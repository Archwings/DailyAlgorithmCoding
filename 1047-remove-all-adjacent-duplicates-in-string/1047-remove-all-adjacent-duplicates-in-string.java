class Solution {
    public String removeDuplicates(String s) {
        // Use two pointers method where we find the first duplicate, remove it, then decrement the pointers by 1 and check if they are pointing to a duplicate. 
        int left = 0;
        int right = 1;
        
        while (right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                s = s.substring(0, left) + s.substring(right+1);
                if (left == 0 ) {
                    left = 0;
                    right = 1;
                } else {
                   left--;
                    right--; 
                }
            } else {
                left++;
                right++;
            }
        }
        return s;
    }
}