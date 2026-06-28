class Solution {
    public int findMin(int[] nums) {
        // Init left, right pointer
        // Start from middle
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // compare mid number with tne most right num
            // if mid > right -> min is between mid , right
            // if mid < right -> min is between mid, left
            if (nums[mid] > nums[r]) l = mid + 1;
            if (nums[mid] < nums[r]) r = mid;
        }

        return nums[l];
    }
}
