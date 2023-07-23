class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean containsOdd = false;
        for (char c : charCounts.keySet()) {
            int count = charCounts.get(c);
            res += (count / 2) * 2;
            if (count % 2 == 1)
                containsOdd = true;
        }

        return containsOdd ? res + 1 : res;
    }
}