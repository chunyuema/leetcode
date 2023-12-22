class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int left = (s.charAt(0) == '0') ? 1 : 0;
        int right = (s.charAt(0) == '1') ? totalOnes - 1 : totalOnes;
        int maxScore = left + right;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                right--;
            } else {
                left++;
                maxScore = Math.max(left + right, maxScore);
            }
        }

        return maxScore;
    }
}