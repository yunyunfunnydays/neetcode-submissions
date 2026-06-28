class Solution {
    public int characterReplacement(String s, int k) {
        // maxLen = 0
        // l = 0
        // count = int[26]
        // maxFreq = 0
        // FOR r FROM 0 TO n - 1
            // count[sr] + 1
            // UPDATE map sr, freq
            // maxFreq = max(maxFreq, freq)
            // IF (r - l + 1) - maxFreq > K (get a legal max lenth of window and move right)
                // count[sl] - 1
                // l++
            // END IF
            // maxLen = max(maxLen, (r - l + 1))
        // END FOR
        // RETURN maxLen

        int maxLen = 0;
        int l = 0;
        int[] count = new int[26];
        int maxFreq = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            int freq = ++count[c - 'A'];

            maxFreq = Math.max(maxFreq, freq);
            if ((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, (r - l + 1));
        }
          return maxLen;
    }  
}
