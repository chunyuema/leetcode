class Solution {
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        if (l > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - l + 1; i++) {
            if (haystack.substring(i, i + l).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}