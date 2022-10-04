class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        // i is row, j is col
        int rowLength = picture.length;
        int colLength = picture[0].length;
        int[] rows = new int[rowLength];
        int[] cols = new int[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}