class Solution {
    public String maximumOddBinaryNumber(String s) {
        int numOfOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                numOfOnes++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfOnes - 1; i++)
            sb.append("1");
        for (int i = 0; i < s.length() - numOfOnes; i++)
            sb.append("0");
        sb.append("1");
        return sb.toString();
    }
}