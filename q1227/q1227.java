class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) return 1;

        // The probability of current pick choosing the correct seat
        double prob = (double) 1 / n;

        for (int i = 1; i < n - 1 i++) {
            prob = prob + prob * (double) 1 / (n - i + 2);
        }

        return 1 - prob;
    }
}