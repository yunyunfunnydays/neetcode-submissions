class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        for (int n : nums) {
            if (!seen.add(n)){
                return true;
            }
        }

        return false;
        
    }
}