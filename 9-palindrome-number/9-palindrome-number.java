class Solution {
    public boolean isPalindrome(int x) {
        // reverse the given number
        if (x < 0) return false;
        int reverserd = 0;
        int remainder;
        int original = x;
        
        while(x != 0) {
            remainder = x % 10;
            reverserd = reverserd *10 + remainder;
            x /= 10;
        }
        
        return original == reverserd;
        
        
    }
}