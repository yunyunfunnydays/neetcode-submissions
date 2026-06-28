class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // 從 2 開始處理
        int prevMax = 0;
        int currMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        } 

        return currMax;
    }
}
