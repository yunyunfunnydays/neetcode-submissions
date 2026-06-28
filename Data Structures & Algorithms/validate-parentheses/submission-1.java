class Solution {
    public boolean isValid(String s) {
        // Corner case check (e.g. length is singular)
        // Initialize Stack
        if (s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            // If c is an open bracket
                // push the corresponding closing bracket to stack
            // else  
                // If stack is empty return false
                // Pop top from stack, if isn't equal return false
            if (c == '[') {
                stack.push(']');
            } else if ( c == '(') {
                stack.push(')');
            } else if ( c == '{') {
                stack.push('}');
            } else {
                if (stack.size() == 0) return false;
                if (stack.pop() != c) return false;
            }
        }
        if (stack.size() > 0) return false;
        return true;
    }
}
