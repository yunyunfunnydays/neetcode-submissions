class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int count1 = getPalindromeNum(s, i, i);
            int count2 = getPalindromeNum(s, i, i + 1);

            count = count + count1 + count2;
        }

        return count;
    }

    private int getPalindromeNum(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
