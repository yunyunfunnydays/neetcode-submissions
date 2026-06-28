class Solution {
    public boolean isPalindrome(String s) {
        // l = 0 
        // r = s length - 1
        int left = 0;
        int right = s.length() - 1;

        // WHILE l < r:
        while (left < right){
            // IF sl/sr is not non-alphanumeric
                // l++/r-- break;
            // sl/sr to lowercase 
            // IF sl != sr Return false
            // l++, r--
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
            
        }
            
        // RETRUN true
        return true;

    }
}
