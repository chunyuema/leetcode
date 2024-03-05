class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int low = 0;
        int high = tokens.length - 1;
        int score = 0;
        while (low <= high) {
            // score whenever it is possible
            // score but avoid depleting power by using the smallest token
            if (power >= tokens[low]) {
                score += 1;
                power -= tokens[low];
                low += 1;
            }

            // only gain power when have to
            // lose score but maximize the power gained by using the largest token
            else if (score > 0 && low < high) {
                score -= 1;
                power += tokens[high];
                high -= 1;
            }

            else
                return score;
        }
        return score;
    }
}