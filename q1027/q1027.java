class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer, Integer>[] memo = new HashMap[nums.length];
        // Arrays.fill(memo, new HashMap<Integer, Integer>());
        int maxLen = 0;
        for (int r = 0; r < nums.length; r++) {
            memo[r] = new HashMap<Integer, Integer>();
            for (int l = 0; l < r; l++) {
                int diff = nums[l] - nums[r];
                int prevMaxLen = memo[l].getOrDefault(diff, 1);
                memo[r].put(diff, prevMaxLen + 1);
                maxLen = Math.max(maxLen, memo[r].get(diff));
            }
        }
        return maxLen;
    }
}