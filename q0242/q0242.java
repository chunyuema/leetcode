class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] characterMapS = new int[26];
        int[] characterMapT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            characterMapS[charS - 'a']++;
            characterMapT[charT - 'a']++;
        }

        return Arrays.equals(characterMapS, characterMapT);
    }
}