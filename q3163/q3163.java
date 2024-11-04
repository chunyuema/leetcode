class Solution {
    public String compressedString(String word) {
        if (word == null || word.isEmpty()) {
            return ""; // Handle empty or null input
        }

        StringBuilder sb = new StringBuilder();
        char prevChar = word.charAt(0);
        int charCount = 1;

        for (int i = 1; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (currChar == prevChar && charCount < 9) {
                charCount++;
            } else {
                sb.append(charCount).append(prevChar);
                charCount = 1; // Reset for the new character
                prevChar = currChar;
            }
        }

        // Append the last character count and character
        sb.append(charCount).append(prevChar); 
        return sb.toString();
    }
}

