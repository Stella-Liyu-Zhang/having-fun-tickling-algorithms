class Solution {

    private int[][] directions = {{-1,0} , {0,-1}, {1,0}, {0,1}}; 

    public int orangesRotting(int[][] grid) {
        //See minimum, and a matrix, we think about BFS
        // 1 <= m, n <= 10, ONLY 100 cells, ensure the minimum path would be found first
        // Use a queue to store the positions
        
        //first, compute how many fresh oranges there are
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        //put all the rotten oranges into a queue
        //Store the position into the queue as i*n+j
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == 2){
                    queue.add(i*grid[0].length+j);
                }
            }
        }

        //Run BFS
        int minutes = 0;
        while (!queue.isEmpty() && freshOranges > 0){
            int size = queue.size();
            for (int i = 0; i < size; i ++){
                int curr = queue.poll();
                int row = curr/grid[0].length;
                int col = curr % grid[0].length;
                for(int[] direction: directions){
                    int x = direction[0] + row;
                    int y = direction[1] + col;
                    if (x > -1 && y > -1 && x < grid.length && y < grid[0].length && grid[x][y] == 1){
                        queue.add(x*grid[0].length + y);
                        freshOranges --;
                        grid[x][y] = 2;
                    }
                }
            }
            minutes ++;
        }


        return freshOranges == 0 ? minutes : -1;

    }
}