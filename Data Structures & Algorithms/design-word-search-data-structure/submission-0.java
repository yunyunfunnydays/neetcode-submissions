class WordDictionary {
    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs (word, 0, root);
    }

    private boolean dfs (String word, int index, TrieNode node){
            if (index == word.length()) {
                return node.isEnd;
            }

            char c = word.charAt(index);

            if (c == '.') {
                for (TrieNode n : node.children) {
                    if(n != null){
                        if(dfs(word, index + 1, n)) return true;
                    }
                }
                return false;
            } else {
                int i = c - 'a';
                if (node.children[i] == null) {
                    return false;
                }
                node = node.children[i];
                return dfs(word, index + 1, node);
            }
    }
}
