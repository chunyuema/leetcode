class Solution {
    public String decodeAtIndex(String s, int k) {
        long totalLen = 0;

        // go forward
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                totalLen *= Integer.parseInt(String.valueOf(c));
            else
                totalLen++;
        }

        // reverse to look for the character
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                totalLen /= Integer.parseInt(String.valueOf(c));
                k %= totalLen;
            } else {
                if (k == 0 || totalLen == k)
                    return String.valueOf(c);
                totalLen--;
            }
        }
        return "";
    }
}