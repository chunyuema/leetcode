package q2024;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int totalT = 0;
        int totalF = 0;
        while (r < answerKey.length()) {
            // Step 1: Expand the window to take in the new character.
            char rAnswer = answerKey.charAt(r);
            if (rAnswer == 'T') {
                totalT++;
            } else {
                totalF++;
            }

            // Step 2: Optionally shrink the window until constraint is met again.
            // If we have more than k of both T and F, there is a problem as it requires us
            // to flip more than k number of either T or F. The window condition is as long
            // as either the total number of T or F is less than k, the window is a valid
            // window.
            while (totalT > k && totalF > k) {
                char lAnswer = answerKey.charAt(l);
                if (lAnswer == 'T') {
                    totalT--;
                } else {
                    totalF--;
                }
                l++;
            }

            // Step 3: Compute and update the maximum length
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}