class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;

        // Keeps track of the maximum of values[i] + i we have observed
        int prevMax = values[0] + 0; 

        // Loop through all the j indices
        for (int j = 1; j < values.length; j++) {
            // Update the maxScore with (previous max of values[i] + i) + (currend values[j] - j)
            maxScore = Math.max(prevMax + values[j] - j, maxScore);

            // Update the max value of values[i] + i for future references
            prevMax = Math.max(prevMax, values[j] + j);
        }
        return maxScore;
    }
}
