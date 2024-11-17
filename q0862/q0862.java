class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long currSum = 0;
        int currMinLen = Integer.MAX_VALUE; 

        // PQ which stores the (prefixSum, endIdx), sorted by min -> max for prefixSum
        PriorityQueue<Pair<Long, Integer>> prefixSumAndEndIdx = new PriorityQueue<>(
            (p1, p2) -> Long.compare(p1.getKey(), p2.getKey())
        );

        for (int r = 0; r < nums.length; r++) {
            // expand the window 
            currSum += nums[r];

            // update currMinLen if the condition is met
            if (currSum >= k) {
                currMinLen = Math.min(currMinLen, r+1);
            }

            // shrink the window as long as the condition could permit
            while (!prefixSumAndEndIdx.isEmpty() &&
                    currSum - prefixSumAndEndIdx.peek().getKey() >= k) {

                // get the left bound of the subarray which satisfy the condition
                int l = prefixSumAndEndIdx.poll().getValue();

                // update the min len of the window
                currMinLen = Math.min(currMinLen, r - l);
            }

            // add currSum on to the heap
            prefixSumAndEndIdx.offer(new Pair<>(currSum, r));
            
        }
        return currMinLen == Integer.MAX_VALUE ? -1 : currMinLen;
    }
}