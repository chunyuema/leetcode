class Solution {
    public int appendCharacters(String s, String t) {
        int ps = 0;
        int pt = 0;
        while (ps != s.length() && pt != t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                pt++;
            }
            ps++;
        }
        return t.length() - pt;
    }
}