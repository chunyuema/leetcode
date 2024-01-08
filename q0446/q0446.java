class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // Let dp[i] = map with
        // - key as possible difference in the arithmetic subsequences
        // - value as the number of prev nums (len of of subsequence) with the diff
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; ++i)
            dp[i] = new HashMap<>();

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // Get the difference between current num and previous num
                long diffLong = (long) nums[i] - nums[j];
                if (diffLong > Integer.MAX_VALUE || diffLong < Integer.MIN_VALUE)
                    continue;
                int diff = (int) diffLong;

                // Update the total number of arithmetic subsequences (with curr diff)
                int prevChainLen = dp[j].getOrDefault(diff, 0);
                // With all the subsequences until num j, num i can form one additional
                // subsequence
                total += prevChainLen;

                // Compute the current chain len
                int currChainLen = prevChainLen + dp[i].getOrDefault(diff, 0) + 1;
                dp[i].put(diff, currChainLen);
            }
        }
        return total;
    }
}