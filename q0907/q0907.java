class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int mod = 1000000007;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;
        long res = 0;
        for (int currIndex = 0; currIndex <= n; currIndex++) {
            while (!stack.isEmpty() && (currIndex == n || arr[currIndex] <= arr[stack.peek()])) {
                int prevIndex = stack.pop();
                int prevNum = arr[prevIndex];

                // The left boundary is the index of the last number smaller than the prevNum
                int left = stack.isEmpty() ? -1 : stack.peek();

                // The right boundary is the current index as the current number evicted prevNum
                int right = currIndex;

                // Calculate prevCount, the number of times that prevNum will be used in the sub
                // of min(b)
                long prevCount = ((prevIndex - left) * (right - prevIndex)) % mod;

                // Update the res
                res = (res + (prevNum * prevCount) % mod) % mod;
            }
            stack.push(currIndex);
        }
        return (int) res;
    }
}