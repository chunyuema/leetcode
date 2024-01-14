class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] counter1 = new int[26];
        int[] counter2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            counter1[word1.charAt(i) - 'a']++;
            counter2[word2.charAt(i) - 'a']++;
        }

        // The set of characters to consider must match
        for (int i = 0; i < 26; i++) {
            if ((counter1[i] == 0 && counter2[i] != 0) ||
                    (counter1[i] != 0 && counter2[i] == 0))
                return false;
        }

        // The count of all the groups collectively need to match
        // This will allow the final strings to match with operation2
        Arrays.sort(counter1);
        Arrays.sort(counter2);
        return Arrays.equals(counter1, counter2);
    }
}