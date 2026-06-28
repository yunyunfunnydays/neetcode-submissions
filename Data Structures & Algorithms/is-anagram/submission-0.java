class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
    
        var map = new HashMap<Character, Integer>();

        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c, 0)+1);
        } 
        
        for(char c: t.toCharArray()){
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if(map.get(c) < 0) return false;
        }

        for (int v : map.values()){
            if(v != 0) return false;
        }
        return true;
    }
}
