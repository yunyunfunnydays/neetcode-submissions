class Solution {
    public String minWindow(String s, String t) {
        // Corner case check(e.g. s is shorter than t)
        // Build frequency map(need array) for t
        // Initailize pointer(left, right) and tracking variables(count, minLen)
        if(s == null || t == null || s.length() == 0 ||t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        int[] need = new int[128];
        int count = 0;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        while (right < s.length()) {
            // Add current char to window ,update need and count
            char c = s.charAt(right);
            if (need[c] > 0) {
                count++;
            }
            need[c]--;

            // shrink if the window is valid (count == t len)
            while (count == t.length()) {
                // update minlen and start
                // remove left char form window, restore need
                // restore count if char meet need
                // left++
                if (right - left + 1 < minLen){
                    start = left;
                    minLen = right - left + 1;
                }
                need[s.charAt(left)]++;
                if (need[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
            // move right pointer
            right++;
        }

        //return substring
        return minLen ==  Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        
    }
}
