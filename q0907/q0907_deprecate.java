class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int mod = 1000000007;
        final int n = arr.length;

        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Long> numCounts = new ArrayDeque<>();
        // Build numberOfLargerNumbersLeft
        long[] numberOfLargerNumbersLeft = new long[n];
        Arrays.fill(numberOfLargerNumbersLeft, 1);
        for (int i = 0; i < n; ++i) {
            int currNum = arr[i];
            while (!nums.isEmpty() && nums.peek() > currNum) {
                nums.pop();
                int leftLargerCount = numCounts.pop();
                numberOfLargerNumbersLeft[i] += leftLargerCount;
            }
            nums.push(currNum);
            numCounts.push(numberOfLargerNumbersLeft[i]);
        }

        nums.clear();
        numCounts.clear();
        // Build numberOfLargerNumbersRight
        long[] numberOfLargerNumbersRight = new long[n];
        Arrays.fill(numberOfLargerNumbersRight, 1);
        for (int i = n - 1; i >= 0; --i) {
            int currNum = arr[i];
            while (!nums.isEmpty() && nums.peek() >= currNum) {
                nums.pop();
                int rigthLargerCount = numCounts.pop();
                numberOfLargerNumbersRight[i] += rigthLargerCount;
            }
            nums.push(currNum);
            numCounts.push(numberOfLargerNumbersRight[i]);
        }

        long res = 0;
        for (int i = 0; i < n; ++i) {
            res += (long) arr[i] * numberOfLargerNumbersLeft[i] * numberOfLargerNumbersRight[i];
        }
        return (int) (res % mod);
    }
}