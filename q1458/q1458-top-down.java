class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dpHelper(nums1, nums2, 0, 0, memo);
    }

    private int dpHelper(final int[] nums1, final int[] nums2, int i, int j, int[][] memo) {
        // Base case: Check if we are at the end of either nums1 or nums2
        if (i >= nums1.length || j >= nums2.length) {
            return Integer.MIN_VALUE; // Return a very small value as invalid
        }

        // Memoized case
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        // Calculate the possible solutions
        int sol1 = nums1[i] * nums2[j] + Math.max(0, dpHelper(nums1, nums2, i + 1, j + 1, memo));
        int sol2 = dpHelper(nums1, nums2, i + 1, j, memo);
        int sol3 = dpHelper(nums1, nums2, i, j + 1, memo);
        memo[i][j] = Math.max(sol1, Math.max(sol2, sol3));
        return memo[i][j];
    }
}