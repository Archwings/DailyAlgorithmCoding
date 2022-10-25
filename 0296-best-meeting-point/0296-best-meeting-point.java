class Solution {
    public int minTotalDistance(int[][] grid) {
        //friends[0] or friends[1] for 
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);
        int m = grid.length;
        int n = grid[0].length;
        
        int row = rows.get(rows.size()/2);
        int col = cols.get(cols.size()/2);
        
        int totalDistanceRows = getTotalDistance(rows, row);
        int totalDistanceCols = getTotalDistance(cols, col);
        
        return totalDistanceRows + totalDistanceCols;
    }
    
    private int getTotalDistance(List<Integer> points, int median) {
        int totalDistance = 0;
        for(int point: points) {
            totalDistance += Math.abs(median - point);
        }
        return totalDistance;
    }
    
    private List<Integer> getRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0 ; i < grid.length; i++) { // m 
            for (int j = 0; j < grid[0].length; j++) { // n 
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }
        return rows;
    }
    
    private List<Integer> getCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int i = 0 ; i < grid[0].length; i++) { // n
            for (int j = 0; j < grid.length; j++) { // m 
                if (grid[j][i] == 1) {
                    cols.add(i);
                }
            }
        }
        return cols;
    }
    
}