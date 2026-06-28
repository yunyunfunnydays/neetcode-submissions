class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
    
        var count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c: t.toCharArray()) {
            count[c-'a']--;
        }

        for (int v: count) {
            if(v != 0) return false;
        }
    
        
        return true;
    }
}
