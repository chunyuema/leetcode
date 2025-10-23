class Solution {
    public boolean hasSameDigits(String s) {
        String currStr = doOperation(s);
        while (currStr.length() != 2) {
            currStr = doOperation(currStr);
        }
        return currStr.charAt(0) == currStr.charAt(1);
    }

    private String doOperation(String s) {
        if (s.length() == 2) return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            int res = ((int)s.charAt(i) + (int)s.charAt(i-1)) % 10;
            sb.append(res);
        }
        return sb.toString();
    }
}
