class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int wp1 = 0;
        int sp1 = 0;

        int wp2 = 0;
        int sp2 = 0;

        while (wp1 < word1.length && wp2 < word2.length) {
            if (word1[wp1].charAt(sp1) != word2[wp2].charAt(sp2))
                return false;

            sp1++;
            if (sp1 == word1[wp1].length()) {
                wp1++;
                sp1 = 0;
            }

            sp2++;
            if (sp2 == word2[wp2].length()) {
                wp2++;
                sp2 = 0;
            }
        }
        return wp1 == word1.length && wp2 == word2.length;
    }
}