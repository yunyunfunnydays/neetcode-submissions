class Solution {
    public int maxProduct(int[] nums) {
        if ( nums == null || nums.length == 0) return 0;
    
        int currMax = nums[0];
        int currmin = nums[0];
        int globalMax = nums[0];        

        for (var i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int temp = currMax;
                currMax = currmin;
                currmin = temp;
            }

            currMax = Math.max(num, currMax * num);
            currmin = Math.min(num, currmin * num);

            globalMax = Math.max(globalMax, currMax);
        }

        return globalMax;
    }
}
