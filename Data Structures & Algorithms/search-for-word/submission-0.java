class Solution {
    public boolean exist(char[][] board, String word) {
        // 建議：使用 h (height) 和 w (width) 或 m, n 來增加可讀性
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    // 修正參數命名：r (row/i), c (col/j), index (當前字元位置)
    private boolean backtrack(char[][] board, String word, int r, int c, int index){
        // Base Case 1: 找到所有字元
        if (index == word.length()) return true;

        // Base Case 2: 邊界檢查 + 字元匹配檢查
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        } 
        
        // --- Choose ---
        char temp = board[r][c];
        board[r][c] = '#';

        // --- Explore ---
        // 修正重點：使用 +1, -1 而非 ++, --
        // index + 1 也只需要寫一次
        boolean found = backtrack(board, word, r + 1, c, index + 1) ||
                        backtrack(board, word, r - 1, c, index + 1) ||
                        backtrack(board, word, r, c + 1, index + 1) ||
                        backtrack(board, word, r, c - 1, index + 1);

        // --- Un-choose / Backtrack ---
        // 因為 r 和 c 沒有被修改，這裡可以正確還原當前格子
        board[r][c] = temp;

        return found;   
    }
}