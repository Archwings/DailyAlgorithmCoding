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
        
        int end = treeMap.lastKey();
        int start = treeMap.firstKey();
        
        int ptr = start;
        
        List<Integer> count = new ArrayList<Integer>(treeMap.values());
        List<Integer> keySet = new ArrayList<Integer>(treeMap.keySet());
        Object[] countArr = count.toArray();
        Object[] keysArr = keySet.toArray();
        
        
         //System.out.println(treeMap.keySet());
        
        
        for (int i = 0; i < countArr.length; i++) {
            //System.out.println(countArr[i]);
            if ((Integer)countArr[i] == rows) {
                return (Integer)keysArr[i]; 
            }
        }
        return -1;

    }
}