class Solution {
    public String makeGood(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // Check if the incoming character will result in a bad pair
            if (!stack.isEmpty() &&
                    (c != stack.peek() && Character.toLowerCase(c) == Character.toLowerCase(stack.peek()))) {
                // Do not add the incoming character, and remove the previous one too
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}