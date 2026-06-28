class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t) :
            return False
        freq = [0] * 26
        for cs, ct in zip(s,t):
            freq[ord(cs) - ord('a')] += 1
            freq[ord(ct) - ord('a')] -= 1
        return all(c == 0 for c in freq)
