class Solution {
    private int[][] memo;  // Memoization table to store palindrome status
    private int currMaxLen;
    private int l; 
    private int r;

    // Let dpHelper(i, j) return the palindrome status bounded by i and j
    private boolean dpHelper(String s, int i, int j) {
        // Base case: If there is only 1 char in the substring or i >= j
        if (i >= j) return true;

        // Memoized case: If we've already computed the value, return it
        if (memo[i][j] != -1) return memo[i][j] == 1;

        // Recursive case: If the characters match, check the inner substring
        if (s.charAt(i) == s.charAt(j) && dpHelper(s, i + 1, j - 1)) {
            memo[i][j] = 1;  // Mark as palindrome
            // Update max palindrome length if necessary
            if (j - i + 1 > currMaxLen) {
                currMaxLen = j - i + 1;  // Update the length of the longest palindrome
                l = i;
                r = j;
            }
            return true;
        }

        // If it's not a palindrome, mark it as false
        memo[i][j] = 0;
        return false;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int n = s.length();
        memo = new int[n][n];
        currMaxLen = 0;
        l = 0;
        r = 0;

        // Initialize memo table with -1 (indicating uncomputed)
        for (int[] row : memo) Arrays.fill(row, -1);

        // Iterate over all possible substrings (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Check palindrome for the substring s[i...j]
                dpHelper(s, i, j);
            }
        }
        
        // Return the longest palindrome substring
        return s.substring(l, r + 1);
    }
}

