class Solution {
    public int maxArea(int[] heights) {
        // l = 0
        // r = n - 1
        // max = 0
        // WHILE l < r
            // min =  min hl, hr
            // area = min * (r - l + 1)
            // max = max area, max
            // IF hl < hr -> l++ else r--
        // END WHILE
        // RETURN max

        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while (l < r) {
            int min = Math.min(heights[l], heights[r]) ;
            int area = min * (r - l);
            max = Math.max(area, max);

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }

        }
        return max;
    }
}
