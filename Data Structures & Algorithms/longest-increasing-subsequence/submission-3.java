class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] tails = new int[n];
        int size = 1;
        tails[0] = nums[0];

        for(var i = 1; i < n; i++) {
            if (nums[i] > tails[size - 1]){
                System.out.print(" nums[i]="+nums[i]);
                tails[size] = nums[i];
                size++;
            } 
            if(nums[i] < tails[size - 1]) {
                for (var j = 0; j < size; j++) {
                    if(nums[i] == tails[j]) break;
                    if (nums[i] < tails[j]) {
                        tails[j] = nums[i];
                        break;
                    }
                }
            }
        }
        for (var a : tails) {
            System.out.print(" tail = "+a);
        }
        return size;
    }
}
