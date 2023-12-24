class Solution {
    public int minOperations(String s) {
        int ops = 0;

        char prevChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (prevChar == currChar) {
                ops++;
                prevChar = prevChar == '1' ? '0' : '1';
            } else {
                prevChar = currChar;
            }
        }
        return Math.min(ops, s.length() - ops);    
    }
}