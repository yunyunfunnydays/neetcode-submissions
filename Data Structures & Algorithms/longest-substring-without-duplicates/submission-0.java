class Solution {
    public int lengthOfLongestSubstring(String s) {
        // maxLen = 0
        // INIT set (for recording char)
        // l = 0
        // FOR r FROM 0 to s.length - 1
            // (check if set already has sr)
            // (yes -> use l to remove util sr is not in set)
            // WHILE sr in set
                // REMOVE sl from set
                // s++
            // END WHILE
            // (no -> put sr into set)
            // PUT sr to set
            // (update  max length)
            // maxLen = max(maxLen, r - l + 1)
        // END FOR
        int maxLen = 0; 
        int l = 0;
        Set<Character> set = new HashSet<>();


        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
