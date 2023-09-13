class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<int[]> stack = new ArrayDeque<>();
        int currMinNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && num >= stack.peek()[0])
                stack.pop();

            if (!stack.isEmpty() && num > stack.peek()[1])
                return true;

            stack.push(new int[] { num, currMinNum });
            currMinNum = Math.min(currMinNum, num);
        }

        return false;
    }
}