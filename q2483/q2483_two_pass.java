class Solution {
    public int bestClosingTime(String customers) {

        // pass 1: count the number of total penalty
        int totalPenalty = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') totalPenalty += 1;
        }

        // pass 2: determine the earliest closing date
        int minClosingTime = customers.length();
        int minPenalty = totalPenalty; 
        int currPenalty = totalPenalty;
        for (int i = customers.length()-1; i >= 0; i--) {
            if (customers.charAt(i) == 'N') {
                currPenalty--;
                if (currPenalty <= minPenalty) {
                    minPenalty = currPenalty;
                    minClosingTime = i;
                }
            } else {
                currPenalty++;
            }
        }

        return minClosingTime;
    }
}