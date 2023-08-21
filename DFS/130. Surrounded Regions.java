class Solution {
    /*

    Touches the border = donot flip
    identify the group of Os that touch the border

    bfs(bfs) make further recursvie call
    O(m*n), Space: O(min(M,N))

    dfs(stack) add another coordinate in queue
    O(m*n), Space: O(m*n)
  
    */

    private int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public void solve(char[][] board) {
        //dfs
        //any time encounter an O, we would be perform dfs
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++){
            markBoard(board, m, n, i, 0);
            markBoard(board, m, n, i, n-1);
        }
        for(int i = 0; i < n; i ++){
            markBoard(board, m, n, 0, i);
            markBoard(board, m ,n , m-1, i);
        }
        flipBoard(board, m, n);
    }
    private void markBoard(char[][] board, int m, int n, int i, int j){
        //dfs
        if(i < 0 || j < 0 || i > m - 1 || j > n-1 || board[i][j] != 'O') return;
        board[i][j] = 'M';
        for(int[] direction: directions){
            int x = direction[0] + i;
            int y = direction[1] + j;
            markBoard(board, m,n,x,y);
        }
        
    }
    private void flipBoard(char[][] board, int m, int n){
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}