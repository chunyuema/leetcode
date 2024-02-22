class Solution {
    public int findJudge(int n, int[][] trust) {
        // Tracking the how many people is one person trusted by
        int[] trustedCount = new int[n + 1];
        // Tracking how many people one person is willing to trust
        int[] trustingCount = new int[n + 1];
        for (int[] pair : trust) {
            trustedCount[pair[1]]++;
            trustingCount[pair[0]]++;
        }

        // Trusted by everyone else (n-1) &&
        // Not trusting anyone else 0
        for (int i = 1; i < n + 1; i++) {
            if (trustedCount[i] == n - 1 && trustingCount[i] == 0)
                return i;
        }
        return -1;
    }
}