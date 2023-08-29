class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String s: tokens) {
            // If we encounter an operator, then the two most immediate integer on the stack are the left and right operands
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int r = stack.pop();
                int l = stack.pop();
                if (s.equals("+")) stack.push(l + r);
                if (s.equals("-")) stack.push(l - r);
                if (s.equals("*")) stack.push(l * r);
                if (s.equals("/")) stack.push(l / r);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}