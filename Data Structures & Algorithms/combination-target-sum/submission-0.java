class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, curr, 0);
        return result;
    }
    private void backtrack (int[] nums, int remain, List<Integer> curr, int start) {
        // 可得結果
            // remain == 0 符合題目要求，加到結果 return
            // >  時返回
            if (remain == 0) {
                result.add(new ArrayList(curr));
                return;
            }

            if (remain < 0) {
                return;
            }

        // 試每個組合
            for (int i = start; i < nums.length; i++) {
                // nums[i] > remain 優化
                if (nums[i] > remain) return;
                // 先在同一個數值找組合（DFS）curr加上數值
                curr.add(nums[i]);
                // backtrack
                backtrack(nums, remain - nums[i], curr, i);
                // 移除 curr 最後一個值
                curr.remove(curr.size() - 1);
                // for loop 自動找下一個值
            }
    }
}
