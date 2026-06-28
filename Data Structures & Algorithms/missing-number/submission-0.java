class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int expectSum = n * (n + 1) / 2;
        int sum = 0;

        for (int num : nums){
            sum += num;
        }

        return expectSum - sum;
        
    }
}
