class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        int expectedCount = words.length;
        for (int count : charMap.values()) {
            if (count % expectedCount != 0)
                return false;
        }
        return true;
    }
}