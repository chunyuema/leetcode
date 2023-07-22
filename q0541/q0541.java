class Solution {
    public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();
        for (int l = 0; l < s.length(); l += 2 * k) {
            int r = Math.min(s.length() - 1, l + k - 1);
            for (int i = l, j = r; i < j; i++, j--) {
                char temp = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = temp;
            }
        }
        return new String(charArr);
    }
}