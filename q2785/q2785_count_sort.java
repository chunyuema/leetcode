class Solution {
    private boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String sortVowels(String s) {
        Map<Character, Integer> vowelCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = vowelCount.containsKey(c) ? vowelCount.get(c) : 0;
            vowelCount.put(c, count + 1);
        }

        StringBuilder sb = new StringBuilder();
        String sortedVowel = "AEIOUaeiou";
        int j = 0;
        for (char c : s.toCharArray()) {
            if (!isVowel(c))
                sb.append(c);
            else {
                // Skip to the character which is having remaining count.
                while ((vowelCount.getOrDefault(sortedVowel.charAt(j), 0)) == 0) {
                    j++;
                }

                sb.append(sortedVowel.charAt(j));
                int count = vowelCount.get(sortedVowel.charAt(j));
                vowelCount.put(sortedVowel.charAt(j), count - 1);
            }
        }
        return sb.toString();
    }
}