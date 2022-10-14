class Solution {
    public boolean exist(char[][] board, String word) {
        // DFS
        // when we find the first letter of word, do a DFS

        boolean ans = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if we can find the first letter, and all the following letters with the
                // recursive method
                if (board[i][j] == word.charAt(0) && DFS(board, word, i, j, 0) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean DFS(char[][] board, String word, int i, int j, int count) {
        // Once we get to the whole word, we are done
        if (count == word.length()) {
            return true;
        }
        /*
         * if off bounds, letter is seen, letter is unequal to word.charAt(start) return
         * false
         */
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0'
                || board[i][j] != word.charAt(count))
            return false;

        /*
         * set this board position to seen. (Because we can still use this postion
         * later)
         */
        char temp = board[i][j];
        board[i][j] = '0';
        /* recursion on all 4 sides for next letter, if works: return true */
        boolean found = DFS(board, word, i + 1, j, count + 1) ||
                DFS(board, word, i, j + 1, count + 1) ||
                DFS(board, word, i, j - 1, count + 1) ||
                DFS(board, word, i - 1, j, count + 1);
        // set the current cell back to unseen.
        board[i][j] = temp;
        // return if found or not
        return found;
    }
}