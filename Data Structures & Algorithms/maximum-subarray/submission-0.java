class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (currMax <= 0){
                currMax = nums[i];
            } else {
                currMax += nums[i];
            }
            maxSum = Math.max(maxSum, currMax);
        }

        return maxSum;
    }
}
