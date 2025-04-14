class Solution {
    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        Arrays.fill(memo, -1);
        return dpHelper(questions, 0, memo); 
    }

    // dpHelper(i) represents the maxPoints you could accumulate if you start answering questions from the i-th question 
    private long dpHelper(int[][] questions, int i, long[] memo) {
        // base case: if we are already at the last one return 0
        if (i >= questions.length) return 0;

        // memoized case: 
        if (memo[i] != -1) return memo[i];

        // recursive case: 
        int[] currQuestion = questions[i];
        long skip = dpHelper(questions, i+1, memo);
        long noSkip = currQuestion[0] + dpHelper(questions, i + currQuestion[1] + 1, memo);
        
        // memoize the result
        memo[i] = Math.max(skip, noSkip);
        return memo[i];
    }
}
