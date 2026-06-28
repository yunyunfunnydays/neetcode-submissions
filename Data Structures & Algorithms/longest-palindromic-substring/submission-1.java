class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int longest = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = findPalindrome(s, i, i);
            int len2 = findPalindrome(s, i, i + 1);
            int currMax = Math.max(len1, len2);
            if(currMax > longest){
                longest = currMax;
                start = i - (currMax - 1) / 2;
            }
        }
        return s.substring(start, start + longest);
    }
    private int findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }
        return right - left - 1;
    }
}
