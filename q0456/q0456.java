class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<int[]> stack = new ArrayDeque<>();

        // Keep track of the minPrevNum before up until an index i
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Get the current number
            int currNum = nums[i];

            // Keep the stack monotonically decreasing to find the 3 -> 2 pattern
            while (!stack.isEmpty() && currNum >= stack.peek()[0])
                stack.pop();

            // currNum can form a 3 -> 2 pattern with the prevNum
            // Check if the currMin of the prevNum can form 1 -> 2 with currNum
            if (!stack.isEmpty() && currNum > stack.peek()[1])
                return true;

            // Keep track of the pair of [currNum, currMin] on the stack
            stack.push(new int[] { currNum, currMin });
            
            // Update the currMin for the next iterations of the numbers
            currMin = Math.min(currNum, currMin);
        }

        return false;
    }
}