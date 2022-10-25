class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return compoundArray(word1).equals(compoundArray(word2));
        
    }
    private String compoundArray(String[] word) {
        StringBuilder build = new StringBuilder();
        for(String comp: word) {
            build.append(comp);
        }
        return build.toString();
    }
}