class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, int[]> charInfo = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charInfo.containsKey(c)) {
                charInfo.get(c)[1] = i; 
            } else {
                charInfo.put(c, new int[]{i, -1});
            }
        }

        int total = 0; 
        for (int[] range : charInfo.values()) {
            int l = range[0];
            int r = range[1];
            Set<Character> unique = new HashSet<>(); 
            for (int i = l + 1; i < r; i++) {
                unique.add(s.charAt(i));
            }
            total += unique.size();
        }
        return total;
    }
}
