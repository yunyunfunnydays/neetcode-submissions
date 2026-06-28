class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Initial output array
        int[] output = new int[nums.length];
        //prefix = 1
        int prefix = 1;
        //for i from 0 to n-1
            //output[i] = prefix 
            //prefix = prefix * nums[i]

        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix = prefix * nums[i];
        }
        
        //postfix = 1
        //for i from n-1 to 0
            //output[i] = postfix
            //postix = postfix * nums[i]
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix = postfix * nums[i];
        }
        //return output
        return output;

    }
}  
