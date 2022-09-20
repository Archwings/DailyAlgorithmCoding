class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        // Use a hashmap to store each word in words, use this for lookup 
        // Looking a this question, there are 2 main cases, 
        // Case 1: both strings are the same length. Thus, the (concat of the two words) = (concat of the two words reversed) therefore, add the [pair].
        // Case 2: Strings are of different length, thus we need to look at the prfix and suffix of the words
        // for prefix, for each word, we will search each palendrome that exists from the start of the word to word length -2 (as that would be the full word). Then check if the suffix exists in the map. If so, add it to the map
        // Do the same for the suffix insead of the prefix above, and then search for the prefix. 
        // Note that we dont want to check of 2 of the same words are palendrome, so skip if youre comparing the same word.
        
        // Note that we use a TreeSet, so that when we find palindromes, we only check for the remaining strings that are of length added in the set.
        
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
            set.add(words[i].length());
        }
        // Iterate through the list of the words
        for (int i = 0; i < words.length; i ++) {
            StringBuilder build = new StringBuilder();
            build.append(words[i]);
            build.reverse();
            // Case 1: Check if there exists a reverse of the word 
            if(map.containsKey(build.toString())) {
                if (map.get(build.toString()) != i) {
                    list.add(Arrays.asList(i, map.get(build.toString())));
                } 
            }
        
            
            // Case 2.1: for each prefix palindrome, take the suffix and check if its reverse is in the map
            for (Integer j: set) {
                //System.out.println(j + " herej");
                if (j == words[i].length()) {
                   break;
                }
                
                // System.out.println(j + " herej");
                // System.out.println(i + " herei");
                if (isPalendrome(words[i], 0, words[i].length()-j)) {
                    
                    String curr = words[i].substring(words[i].length()-j, words[i].length());
                    curr = reverseString(curr);
                    if (map.containsKey(curr)) {
                        list.add(Arrays.asList(map.get(curr), i));
                        // System.out.println( " i after added");
                        // System.out.println( map.get(curr) +""+ i);
                    }
                }
            
            // Case 2.2: for each suffix palindrome, take the prefix and check if tis reverse is in the map
            //for (Integer j: set) {
                if (isPalendrome(words[i], j, words[i].length())) {
                    String curr = words[i].substring(0, j); 
                    // System.out.println(curr + " actualSTRING");
                    curr = reverseString(curr);
                    if(map.containsKey(curr)) {
                        list.add(Arrays.asList(i, map.get(curr)));
                        
                        // System.out.println( " i before added");
                        // System.out.println(j+ " j");
                        // System.out.println(i +""+ map.get(curr));
                    }
                }
            }
        }
        return list;
 
        
    }
    private boolean isPalendrome(String word, int i, int j) {
        String portion = word.substring(i, j);
        StringBuilder build = new StringBuilder();
        build.append(portion);
        //System.out.println(build.toString() + " STRING");
        String normal = build.toString();
        String reverse = build.reverse().toString();
        
        return normal.equals(reverse);
    }
    private String reverseString(String word){
        StringBuilder build = new StringBuilder();
        build.append(word);
        build.reverse();
        return build.toString();
    }
}