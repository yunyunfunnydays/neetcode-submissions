class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int maxReach = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
               return false; 
            }
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= n)  return true;
        }
        return true;
    }
}
