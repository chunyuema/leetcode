class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenLettersSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) brokenLettersSet.add(c);

        int res = 0;
        for (String word : text.split(" ")) {
            if (canBeTyped(word, brokenLettersSet)) {
                res++;
            }
        }
        return res;
    }

    private boolean canBeTyped(String word, Set<Character> brokenLettersSet) {
        for (char c : word.toCharArray()) {
            if (brokenLettersSet.contains(c)) return false;
        } 
        return true;
    }
}
