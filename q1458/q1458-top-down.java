class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return dpHelper(nums1, nums2, nums1.length - 1, nums2.length - 1, memo);
    }

    private int dpHelper(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0)
            return Integer.MIN_VALUE;
        if (memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j];
        int sol1 = Math.max(0, dpHelper(nums1, nums2, i - 1, j - 1, memo)) + nums1[i] * nums2[j];
        int sol2 = dpHelper(nums1, nums2, i - 1, j, memo);
        int sol3 = dpHelper(nums1, nums2, i, j - 1, memo);
        int res = Math.max(sol1, Math.max(sol2, sol3));
        memo[i][j] = res;
        return res;
    }
}