class Solution {
    public String reverseWords(String s) {
        int length = s.length()-1;
        int count = 0;
        StringBuilder build = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            if (i == length) {
                for (int j = 0; j <= count; j++) {
                    build.append(s.charAt(i-j));
                }
                return build.toString();
            } else 
            if (s.charAt(i+1) == ' ') {
                for (int j = 0; j <= count; j++) {
                    build.append(s.charAt(i-j));
                }
                i++;
                build.append(" ");
                count = 0;
            }
            if (s.charAt(i) != ' ') {
                count++;
            }
        }
        return build.toString();
    }
}