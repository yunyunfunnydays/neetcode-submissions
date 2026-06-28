class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(getMaxMoney(nums, 0, nums.length - 1),
                        getMaxMoney(nums, 1, nums.length));
    }

    private int getMaxMoney(int[] nums, int start, int end){
        int prevMax = 0;
        int currMax = 0;
        
        for (int i = start; i < end; i++) {
           int temp = currMax;
           currMax = Math.max(prevMax + nums[i], currMax);
           prevMax = temp; 
        }
        return currMax;
    }
}
