class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // Sort the numbers to facilitate the subset condition

        // dp[i] = largest subset ending in index i
        int[] dp = new int[nums.length];
        // prev[i] = index of the previous number
        int[] prev = new int[nums.length];

        Arrays.fill(dp, 1); 
        Arrays.fill(prev, -1);

        // index of last element of the largest subset
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    int len = dp[j] + 1;
                    if (len > dp[i]) {
                        dp[i] = len;
                        prev[i] = j;
                    }
                }
            }
            // update the maxIndex;
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }

        // Reconstruct the final solution
        List<Integer> res = new ArrayList<>();
        while (maxIndex >= 0) {
            res.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return res;
    }

}
