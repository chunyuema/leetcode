class Solution {
    public String minRemoveToMakeValid(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If it is a closing parenthesis, and there is a matching open one: remove both
            if (c == ')' && (!stack.isEmpty() && s.charAt(stack.peek()) == '(')) {
                stack.pop();    
            } 
            // Otherwise simply push it on to the stack for future tracking
            else if (c == ')' || c == '(') {
                stack.push(i);
            }
        }
        
        // Rebuild the string by removing the parentheses that are on the stack (not properly closed)
        StringBuilder sb = new StringBuilder(s);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }
}