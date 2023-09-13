class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currTemp = temperatures[i];
            // maintain the stack to be monotonic decreasing
            while (!stack.isEmpty() && currTemp >= temperatures[stack.peek()])
                stack.pop();

            // update the res if there is anything left on the stack
            if (!stack.isEmpty())
                res[i] = stack.peek() - i;

            // push the currTemp index onto the stack for future tracking
            stack.push(i);
        }

        return res;
    }
}