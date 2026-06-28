class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int ansWithoutCarry = a ^ b;
            int carry = (a & b) << 1;

            a = ansWithoutCarry;
            b = carry;
        }
        return a;
        
    }
}
