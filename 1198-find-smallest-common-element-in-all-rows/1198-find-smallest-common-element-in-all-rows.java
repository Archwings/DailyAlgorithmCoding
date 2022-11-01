class Solution {
    public int smallestCommonElement(int[][] mat) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int rows = mat.length;
        
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                treeMap.put(mat[i][j], treeMap.getOrDefault(mat[i][j], 0)+1);
            }
        }
        
        for(int key : treeMap.keySet()){
            if(treeMap.get(key) == mat.length) {
                return key;
            }
        }
        return -1;

    }
}