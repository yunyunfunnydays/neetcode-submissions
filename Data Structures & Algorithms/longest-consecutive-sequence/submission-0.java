class Solution {
    public int longestConsecutive(int[] nums) {
        //INITIAL longest
        int longest = 0;
        //SET all nums into Set
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        //FOR EACH num n in Set:
            //IF n-1 is not in set (start of a sequence)
                //SET length = 1
                //While (n + length) is in the set:
                    //length++
                //UPDATE longest = max(longest, length)
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int length = 0;
                int currentNum = n;
                while (set.contains(currentNum)){
                    length++;
                    currentNum++;
                }
                longest = Math.max(longest, length);
            }
        }
        //RETURN longest
        return longest;

    }
}
