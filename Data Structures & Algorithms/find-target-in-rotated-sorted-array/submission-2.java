class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // case1: Target found at mid
            if (nums[mid] == target) return mid;
            // case2: Identify which falf is sorted
            // if left is sorted
                // check if target is between
            // else check if target  in right
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target  && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
