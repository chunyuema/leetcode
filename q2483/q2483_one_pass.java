class Solution {
    public int bestClosingTime(String customers) {
        int minPenalty = 0;
        int currPenalty = 0;
        int minClosingTime = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                currPenalty--;
                if (currPenalty < minPenalty) {
                    minPenalty = currPenalty;
                    minClosingTime = i + 1;
                }
            } else {
                currPenalty++;
            }
        }

        return minClosingTime;
    }
}