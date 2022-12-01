class Solution {
    public boolean halvesAreAlike(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        int length = s.length();
        
        String a = s.substring(0, length/2);
        String b = s.substring(length/2, length);
        
        int vowelCntA = 0;
        int vowelCntB = 0;
        
        for (char symb : a.toCharArray()) {
            for (char vowel: vowels) {
                if (symb == vowel) {
                vowelCntA++;
                }
            }
        }
        
        for (char symb : b.toCharArray()) {
            for (char vowel: vowels) {
                if (symb == vowel) {
                vowelCntB++;
                }
            }
        }
        return (vowelCntA == vowelCntB);
    }
}