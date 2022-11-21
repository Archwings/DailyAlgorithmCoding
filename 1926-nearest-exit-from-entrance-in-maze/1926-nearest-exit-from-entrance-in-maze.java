class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // Find the nearest exit in a given graph maze.
        // Since we're given a maze, and want to find the nearest exit. I will approach the problem with search because we are trying to find a path from a givin location. Our options are either a BFS search or, a DFS search. Since there can be multiple exits, and we want the clsoest one, we can approach the problem using a BFS search. Using a BFS search, we can stop the search once we hit an exit. 
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] start =  new int[] {entrance[0] , entrance[1], 0};
        queue.add(start);
        maze[start[0]][start[1]] = 'x';
        int height = maze.length - 1;
        int width = maze[0].length - 1;
        
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            
            //check 4 directions around current position
            // up
            if (pos[0] != 0 && maze[pos[0] - 1][pos[1]] == '.') {
                maze[pos[0] - 1][pos[1]] = 'x';
                if (pos[0] == 1 || pos[1] == 0 || pos[1] == width) {
                    return pos[2]+1;
                }
                queue.add(new int[]{pos[0] - 1, pos[1], pos[2] + 1});
            }
            // bottom
            if (pos[0] != height  && maze[pos[0] + 1][pos[1]] == '.') {
                maze[pos[0] + 1][pos[1]] = 'x';
                if (pos[0] == height -1 || pos[1] == 0 || pos[1] == width) {
                    return pos[2]+1;
                }
                queue.add(new int[]{pos[0] + 1, pos[1], pos[2] + 1});
            }
            // left
            if (pos[1] != 0 && maze[pos[0]][pos[1] - 1] == '.') {
                maze[pos[0]][pos[1] - 1] = 'x';
                if (pos[1] == 1 || pos[0] == 0 || pos[0] == height) {
                    return pos[2]+1;
                }
                queue.add(new int[]{pos[0], pos[1] - 1, pos[2] + 1});
            } 
            // right
            if (pos[1] != width && maze[pos[0]][pos[1] + 1] == '.') {
                maze[pos[0]][pos[1] + 1] = 'x';
                if (pos[1] == width - 1 || pos[0] == 0 || pos[0] == height) {
                    return pos[2]+1;
                }
                queue.add(new int[]{pos[0], pos[1] + 1, pos[2] + 1});
            }
        }
        return -1;
    }
}