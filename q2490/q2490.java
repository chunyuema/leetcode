class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() -1)) return false;
        for (int i = 1; i < sentence.length()-1; i++) {
            char prev = sentence.charAt(i-1);
            char curr = sentence.charAt(i);
            char next = sentence.charAt(i+1);
            if (curr == ' ' && prev != next) return false;
        }
        return true;
    }
}
