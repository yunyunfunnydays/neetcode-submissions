class Solution {
    public void rotate(int[][] matrix) {
        // 先上下交換再轉置
   
        int n = matrix.length;
        for (int i = 0, l = n - 1; i < l; i++, l--) {
                int[] temp = matrix[i];
                matrix[i] = matrix[l];
                matrix[l] = temp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return ;
    }
}
