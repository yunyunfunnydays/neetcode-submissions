class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int maxSoFar = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxSoFar) {
               return false; 
            }
            maxSoFar = Math.max(maxSoFar, nums[i] + i);
        }
        return true;
    }
}
