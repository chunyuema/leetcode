import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> finalIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            finalIndexMap.put(s.charAt(i), i);
        }

        // track the characters that we use to construct the final string
        Stack<Character> stack = new Stack<>();

        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (!visited.contains(currChar)) {
                while (!stack.isEmpty() && stack.peek() > currChar && i < finalIndexMap.get(stack.peek())) {
                    visited.remove(stack.peek());
                    stack.pop();
                }
                stack.push(currChar);
                visited.add(currChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}