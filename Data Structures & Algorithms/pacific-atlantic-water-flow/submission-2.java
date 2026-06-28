class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // find heights bove pacific and atlantic ocean can arrived
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        List<List<Integer>> result = new ArrayList<>();

        // 處理第一行
        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, pac, heights[i][0]);
            dfs(heights, i, m - 1, atl, heights[i][m - 1]);
        }

        // 處理第一列
        for (int i = 0; i < m; i++) {
            dfs(heights, 0, i, pac, heights[0][i]);
            dfs(heights, n - 1, i, atl, heights[n - 1][i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        
        return result;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int preValue){
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j]) return;
        
        if (heights[i][j] >= preValue) {
            visited[i][j] = true;
            preValue = heights[i][j];
            dfs(heights, i + 1, j, visited, preValue);
            dfs(heights, i, j + 1, visited, preValue);
            dfs(heights, i - 1, j, visited, preValue);
            dfs(heights, i, j - 1, visited, preValue);
        }

    }
}
