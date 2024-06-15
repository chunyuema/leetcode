class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0; 
        
        Set<Character> allowedChars = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            allowedChars.add(allowed.charAt(i));
        }
        
        for (String word : words) {
            if (isAllowed(word, allowedChars)) count++;
        }
        
        return count;
    }
    
    private boolean isAllowed(String word, Set<Character> allowedChars) {
        for (int i = 0; i < word.length(); i++) {
            if (! allowedChars.contains(word.charAt(i))) return false;
        }
        return true;
    }
}