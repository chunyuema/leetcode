class Solution {
    public int numDecodings(String s) {
        // Memoization array
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dpHelper(s, 0);
    }

    private int[] memo;

    // Let dp(i) represent the number of ways to decode starting from index i of the string
    private int dpHelper(String s, int i) {
        // Base case: if we reach the end of the string, we've found a valid decoding
        if (i == s.length()) return 1;

        // If we encounter '0', it's not a valid starting point, so return 0
        if (s.charAt(i) == '0') return 0;

        // Memoized case: if we've already computed this subproblem, return the result
        if (memo[i] != -1) return memo[i];

        // Recursive case:
        int count = 0;

        // Case 1: Take the single character and move to the next
        count += dpHelper(s, i + 1);

        // Case 2: Take two characters and check if the number is between 10 and 26
        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            count += dpHelper(s, i + 2);
        }

        // Memoize the result for this position
        memo[i] = count;

        return count;
    }
}

