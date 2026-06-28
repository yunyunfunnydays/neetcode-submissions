class Solution {
    class TrieNode {
        TrieNode[] children;
        String isWord;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isWord = w;
        }

        var res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){
                dfs(i, j, board, root, res);
            }
        }
        return res;
    }

    private void dfs(int r, int c, char[][] board, TrieNode node, List<String> res) {
        char temp = board[r][c];
        if (temp == '#' || node.children[temp - 'a'] == null) return;
        
        node = node.children[temp - 'a'];
        if (node.isWord != null) { 
            res.add(node.isWord);
            node.isWord = null;
        }

        board[r][c] = '#';
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[nr].length) {
                dfs(nr, nc, board, node, res);
            }
            
        }
        board[r][c] = temp;
    }
}
