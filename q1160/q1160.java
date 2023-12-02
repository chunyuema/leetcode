class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        for (String word : words) {
            if (canForm(word, charCount))
                res += word.length();
        }

        return res;
    }

    private boolean canForm(String word, Map<Character, Integer> charCount) {
        Map<Character, Integer> wordCharCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
        }

        for (Character c : wordCharCount.keySet()) {
            if (!charCount.containsKey(c) ||
                    charCount.get(c) < wordCharCount.get(c))
                return false;
        }

        return true;
    }
}