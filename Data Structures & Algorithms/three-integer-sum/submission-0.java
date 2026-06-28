class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // INIT res
        List<List<Integer>> res = new ArrayList<>();
        // SORT nums
        Arrays.sort(nums);
        int i = 0;
        // WHILE i < n - 2 (first num)
        while (i < nums.length - 2){
            // l = i + 1 (find second num)
            int left = i + 1;
            // r = n - 1 (find third num)
            int right = nums.length - 1;
            // WHILE l < r
                // SUM nums i, l, r
                    // IF sum = 0
                        // res add [nums i, l r]
                        // move l to next different number
                        // move r to next different number 
                    // IF sum > 0
                        // move r to next different number 
                    // IF sum < 0
                        // move l to next different number
                // move i to next different number
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }

            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }

        }
        // RETURN res
        return res;
    }
}
