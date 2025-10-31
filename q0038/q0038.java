class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        return rleHelper(countAndSay(n-1));
    }

    private String rleHelper(final String s) {
        StringBuilder res = new StringBuilder();
        int count = 1; 
        char prevChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (prevChar == currChar) {
                count++;
            } else {
                res.append(count).append(prevChar);
                prevChar = currChar;
                count = 1;
            }
        }
        res.append(count).append(prevChar);
        return res.toString();
    } 
}
