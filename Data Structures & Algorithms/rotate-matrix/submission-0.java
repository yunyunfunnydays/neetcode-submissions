class Solution {
    public void rotate(int[][] matrix) {
        // 先上下交換再轉置
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0, l = m - 1; i < l; i++, l--) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l][j];
                matrix[l][j] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return ;
    }
}
