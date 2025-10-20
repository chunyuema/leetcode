class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1; 
        if (n == 1) return 10;

        int[] dp = new int[n + 1];
        dp[1] = 10;
        dp[2] = 9 * 9; 
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] * (10 - i + 1);
        }

        int total = 0; 
        for (int count : dp) total += count;
        return total;
    }
}
