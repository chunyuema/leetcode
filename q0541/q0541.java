class Solution {
    public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();

        // Find the left bound of the substring to be reversed
        for (int l = 0; l < s.length(); l += 2 * k) {

            // Find the right bound of the substring to be reversed
            int r = Math.min(s.length() - 1, l + k - 1);

            // Reverse the substring bounded by [i, j) in place
            for (int i = l, j = r; i < j; i++, j--) {
                char temp = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = temp;
            }
        }
        return new String(charArr);
    }
}