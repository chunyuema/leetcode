class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
        }

        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            // only check and try to push the currChar if it is not already on the stack
            if (!set.contains(currChar)) { // if (!stack.contains(currChar)) {
                // if the incoming character is smaller than the character currently on the stack, and 
                // if the character on the stack could appear later, pop that character out as it can be added later
                // use a while loop for this as we want to repeatedly do so until what is on the stack absolutely has to be there
                while (!stack.isEmpty() && currChar < stack.peek() && indexMap.get(stack.peek()) > i) {
                    set.remove(stack.pop()); // stack.pop();
                }
                stack.push(currChar);
                set.add(currChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}