class Solution {
    public int[] findBall(int[][] grid) {
        //O(n*nm) where we will check conditions to determine if the ball will make it to the bottom
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println(rows);
        System.out.println(cols);
        int[] output = new int[cols];
        for (int i = 0; i < cols; i++) {
            boolean isStuck = false;
            int level = 0;
            int xpos = i;
            while(!isStuck) {
                if (level == rows-1) {
                    if (grid[level][xpos] == 1 && xpos != cols-1 && grid[level][xpos+1] == 1) {
                        xpos++;
                        break;
                    } else if (grid[level][xpos] == -1 && xpos != 0 && grid[level][xpos-1] == -1) {
                        xpos--;
                        break;
                    }
                    isStuck = true;
                    break;
                }
                // if possible to go to the right without getting stuck
                if (grid[level][xpos] == 1 && xpos != cols-1) {
                    // can reach the next level (floor)
                    if (grid[level][xpos+1] == 1) {
                        xpos = xpos + 1;
                        level = level + 1;
                        continue;
                    } else {
                        isStuck = true;
                    }
                    
                // possible to go to the left without getting stuck
                } else if (grid[level][xpos] == -1 && xpos != 0) {
                    // can reach the next level (floor)
                    if (grid[level][xpos-1] == -1) {
                        xpos = xpos - 1;
                        level = level + 1;
                        continue;
                    } else {
                        isStuck = true;
                    }
                } else {
                    // got stuck on a wall
                    isStuck = true;
                    
                }
            }
            if (isStuck) {
                output[i] = -1;
            } else {
                output[i] = xpos;
            }
        }
        return output;
    }
}