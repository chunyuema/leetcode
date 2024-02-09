class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Let dp[i] represent the largest subset until index i
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        // Track where the largest size of the subset
        int maxSize = 1;
        // Track the index of the largest number in the subset
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        // Reconstruct the answer
        List<Integer> res = new ArrayList<>();
        int prevNum = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            int currNum = nums[i];
            if (prevNum % currNum == 0 && dp[i] == maxSize) {
                res.add(currNum);
                prevNum = currNum;
                maxSize--;
            }
        }
        return res;
    }
}