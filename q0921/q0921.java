class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // If we see an opening paren, push it on to the stack
            if (s.charAt(i) == '(') stack.push('(');

            // If we see a closing paren:
            else {
                // Try to close it if we can (if open paren is available on the stack)
                if (stack.size() != 0) stack.pop();
                // Else, we have no choice but to add an opening paren
                else res++;
            }
        }

        // If we did not use up all the opening paren, then we have no choice but to add all the closing paren
        return res + stack.size();
    }
}