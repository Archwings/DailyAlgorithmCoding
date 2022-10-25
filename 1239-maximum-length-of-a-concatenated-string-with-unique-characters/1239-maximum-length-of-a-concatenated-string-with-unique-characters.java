class Solution {
    public int maxLength(List<String> arr) {
        HashSet<Character> set = new HashSet<>();
        return DFS(arr, set, "", 0);
    }
        
    private int DFS(List<String> arr, HashSet<Character> set, String string, int ind) {
        for (char stringInd: string.toCharArray()) {
            set.add(stringInd);
        }
        if (set.size() != string.length()) {
            return 0;
        }
        
        int best = string.length();
        for (int i = ind; i < arr.size(); i++) {
            best = Math.max(best, DFS(arr, new HashSet<Character>(), string + arr.get(i), i + 1) );
        }
        return best;
    }
}