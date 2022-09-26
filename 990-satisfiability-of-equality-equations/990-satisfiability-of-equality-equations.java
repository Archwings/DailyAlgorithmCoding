class Solution {
    public boolean equationsPossible(String[] equations) {
        // Approach 1 (Naive): for each equation in equations, take each xi and yi with the operator == and add them to a hashmapp. If the operator is '!=' then put the string in a separate String arrayList. After this single pass, we will go through the '!=' ArrayList and check if xil or yil are in the hash map, if say xil is in the hashmap, check if its pair, yil is a value pair, if so, there exists an inequality and return false. Check both xil and yil in the hashmap.
        // Naive - when iterating over the '=' values, we will end up with a bunch of disjoint sets. For each disjoint set, we need to have each character in the set to have a list of all of the other characters in the set, therefore, making it easy to search for discontinuities when we go over the inequalities.
        
//         HashMap<Character, List<Character>> map = new HashMap<>();
//         List<Pair<Character, Character>> listNotEqual = new ArrayList<>();
        
//         for (String equation: equations){
//             if (equation.charAt(1) == '=') {
//                 if (map.containsKey(equation.charAt(0))) {
//                     map.get(equation.charAt(0)).add(equation.charAt(3));
//                 } else {
//                     map.put(equation.charAt(0), new ArrayList<> (Arrays.asList(equation.charAt(3))));
//                 }
//                 if (map.containsKey(equation.charAt(3))) {
//                     map.get(equation.charAt(3)).add(equation.charAt(0));
//                 } else {
//                     map.put(equation.charAt(3), new ArrayList<> (Arrays.asList(equation.charAt(0))));
//                 }
//             } else {
//                 listNotEqual.add(new Pair<>(equation.charAt(3), equation.charAt(0)));
//             }
//         }
//         for (Pair<Character, Character> pair: listNotEqual) {
//             // Contains the ArrayList of Character equalities 
//             Iterator iteratorKey = map.get(pair.getKey()).iterator();
//             if (map.containsKey(pair.getKey())) {
//                 while (iteratorKey.hasNext()) {
//                     if (pair.getValue() == iteratorKey.next()) {
//                         return false;
//                     }
//                 }
//             }
//             Iterator iteratorVal = map.get(pair.getValue()).iterator();
//             if (map.containsKey(pair.getValue())) {
//                 while (iteratorVal.hasNext()) {
//                     if (pair.getKey() == iteratorVal.next()) {
//                         return false;
//                     }
//                 }
//             }
//         }
        
        List<Integer>[] letters = new ArrayList[26];
        int[] colors = new int[26];
        Arrays.fill(colors, -1);
        
        
        for (int i = 0; i < 26; i++) {
            letters[i] = new ArrayList();
        }
        
        for (String equation: equations) {
            if (equation.charAt(1) == '=') {
                int ind1 = equation.charAt(0) - 'a';
                int ind2 = equation.charAt(3) - 'a';
            
                // add the letters in the arra
                letters[ind1].add(ind2);
                letters[ind2].add(ind1);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (colors[i] == -1) {
                dfs(i, i, letters, colors);
            }
        }
        
        for (String eqn : equations) {
            if (eqn.charAt(1) == '!') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                if (colors[x] == colors[y])
                    return false;
            }
        }
        return true;
    }
    private void dfs(int curr, int color, List<Integer>[] letters, int[] colors) {
        if (colors[curr] == -1) {
            colors[curr] = color;
            for (int nei : letters[curr])
                dfs(nei, color, letters, colors);
        }
    }
}