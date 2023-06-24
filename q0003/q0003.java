import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        int l = 0;
        HashMap<Character, Integer> charIndex = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            if (charIndex.containsKey(currChar)) {
                l = Math.max(l, charIndex.get(currChar) + 1);
            }
            longestLength = Math.max(longestLength, r - l + 1);
            charIndex.put(currChar, r);
        }
        return longestLength;
    }
}