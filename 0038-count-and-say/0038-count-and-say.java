class Solution {
    public String countAndSay(int n) {
        String countSoFar = "1";
        for (int i = 2; i <= n; i++) {
            String currCount = "";
            for (int j = 0, k = 0; j < countSoFar.length(); j = k) {
                int count = 0;
                while (k < countSoFar.length() && countSoFar.charAt(j) == countSoFar.charAt(k)) {
                    count++;
                    k++;
                }
                currCount += (Integer.toString(count));
                currCount += countSoFar.charAt(j);
                count = 0;
            }
            countSoFar = currCount;
        }
        return countSoFar;
    }
}