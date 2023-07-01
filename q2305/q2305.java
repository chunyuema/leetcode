package q2305;

class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] cookieDistribution = new int[k];
        return distributeHelper(cookies, cookieDistribution, 0, k);
    }

    private int distributeHelper(int[] cookies, int[] cookieDistribution,
            int currCookieIndex, int k) {

        // If we have finished distributing all the cookies, compute the
        // unfairDistribution
        if (currCookieIndex == cookies.length) {
            int unfairDistribution = Integer.MIN_VALUE;
            for (int c : cookieDistribution) {
                unfairDistribution = Math.max(unfairDistribution, c);
            }
            return unfairDistribution;
        }

        int currMinUnfairDistribution = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            // Allocate the current cookie to the j-th kid,
            // Recursively compute the min unfair distribution in that case
            // Update the current min unfair distribution
            cookieDistribution[j] += cookies[currCookieIndex];
            int newMinUnfairDistribution = distributeHelper(cookies, cookieDistribution, currCookieIndex + 1, k);
            currMinUnfairDistribution = Math.min(currMinUnfairDistribution, newMinUnfairDistribution);

            // Remove current allocation to backtrack
            cookieDistribution[j] -= cookies[currCookieIndex];
        }
        return currMinUnfairDistribution;
    }
}