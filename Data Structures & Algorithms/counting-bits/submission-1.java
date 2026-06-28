class Solution {
    public int[] countBits(int n) {
        if (n < 0) return new int[0];

        int[] bitsCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bitsCount[i] = bitsCount[i >> 1] + (i & 1);

        }
        return bitsCount;
    }
}
