class Solution {
    public int numWays(String[] words, String target) {
        // Length of words in the dictionary
        int wordLen = words[0].length();
        // Length of target string
        int targetLen = target.length();

        // Initialize the charFrequency array
        charFrequency = new int[wordLen][26];
        for (int i = 0; i < wordLen; i++) {
            for (String word : words) {
                int j = word.charAt(i) - 'a';
                charFrequency[i][j]++;
            }
        }

        // Initialize the memo array to store intermediate results
        memo = new int[wordLen][targetLen];
        for (int[] row : memo) Arrays.fill(row, -1);

        // Start the recursive dp helper function
        return (int) dpHelper(words, target, 0, 0);
    }

    private int[][] charFrequency;
    private int[][] memo;

    private long dpHelper(String[] words, String target, int wordsIdx, int targetIdx) {
        // Base case: If we have reached the end of the target string
        if (targetIdx == target.length()) return 1;
        // Base case: If we have no more columns to process
        if (wordsIdx == words[0].length()) return 0;

        // If the result is already memoized, return it
        if (memo[wordsIdx][targetIdx] != -1) return memo[wordsIdx][targetIdx];

        long MOD = 1000000007;
        long totalWays = 0;

        // Option 1: If the current character of the target matches the current column of the words
        int charIdx = target.charAt(targetIdx) - 'a';
        int charFreq = charFrequency[wordsIdx][charIdx];
        totalWays += charFreq * dpHelper(words, target, wordsIdx + 1, targetIdx + 1);

        // Option 2: Skip the current column of words and move to the next
        totalWays += dpHelper(words, target, wordsIdx + 1, targetIdx);

        // Store the result in the memo table, applying modulo
        memo[wordsIdx][targetIdx] = (int) (totalWays % MOD);

        return memo[wordsIdx][targetIdx];
    }
}

