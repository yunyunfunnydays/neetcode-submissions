class Solution {
    public int[] twoSum(int[] nums, int target) {
              var map = new HashMap<Integer, Integer>();
        var first= 0;
        var last = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(map.containsKey(target - n)) {
                last=i; 
                first=map.get(target - n);
                break;
            }
            map.put(n,i);
        }
        var ans = new int[2];
        ans[0] = first;
        ans[1] = last;
        return  ans;
    }
}
