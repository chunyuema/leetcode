class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // If the window grows larger than size k, remove from the left bound to shrink
            // the window
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            // Maintain the deque to be monotonically decreasing. This ensures that what we
            // get from the front is the largest element, hence would be the correct max
            // value
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1)
                res[i + 1 - k] = nums[deque.peekFirst()];
        }
        return res;
    }
}