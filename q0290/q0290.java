class Solution {
    public boolean wordPattern(String pattern, String s) {
        final String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            final char c = pattern.charAt(i);
            final String w = words[i];
            
            if (!charToWord.containsKey(c)) {
                charToWord.put(c, w);
            }
            
            if (!wordToChar.containsKey(w)) {
                wordToChar.put(w, c);
            }
            
            
            if (!w.equals(charToWord.get(c)) ||
                wordToChar.get(w) != c) {
                return false;
            }
        }
        return true; 
    }
}