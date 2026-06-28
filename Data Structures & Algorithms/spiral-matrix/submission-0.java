class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 向右
            for (int j = left; j <= right; j++) {
                int i = top;
                result.add(matrix[i][j]);
            }
            top++;

            // 向下            
            for (int i = top; i <= bottom; i++) {
                int j = right;
                result.add(matrix[i][j]);                
            }
            right--;
            

            // 向左
            if (top <= bottom){
                for (int j = right; j >= left; j--) {
                    int i = bottom;
                    result.add(matrix[i][j]);                    
                }
                bottom--;
            }

            // 向上
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    int j = left;
                    result.add(matrix[i][j]);
                }
                 left++;
            }            
        }
        return result;
    }
}
