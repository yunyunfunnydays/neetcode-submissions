class Solution {
    public int[] twoSum(int[] nums, int target) {
             var map = new HashMap<Integer, Integer>();

        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int need = target - n;
            if(map.containsKey(need)) return new int[]{map.get(need), i};
            map.put(n,i);
        }
        var ans = new int[2];
        return  ans;
    }
}
