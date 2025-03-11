class Solution {
    private String vowelString = "aeiou";

    // Helper function to check if a character is a vowel
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        long totalCount = 0;
        int start = 0;
        int[] vowelCount = new int[5]; // To count occurrences of each vowel
        int consonantCount = 0;
        int vowelPresentCount = 0; // To track the number of distinct vowels in the window

        // Precompute the next consonant index for each position
        int[] nextConsonant = new int[n];
        int nextConsonantIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        // Expand the right boundary of the window
        for (int end = 0; end < n; end++) {
            char endLetter = word.charAt(end);
            int i = vowelString.indexOf(endLetter);

            if (i != -1) {
                if (vowelCount[i] == 0) vowelPresentCount++;
                vowelCount[i]++;
            } else {
                consonantCount++;
            }

            // Shrink window if too many consonants in our window
            while (consonantCount > k) {
                char startLetter = word.charAt(start);
                int j = vowelString.indexOf(startLetter);
                if (j != -1) {
                    vowelCount[j]--;
                    if (vowelCount[j] == 0) vowelPresentCount--;
                } else {
                    consonantCount--;
                }
                start++;
            }

            // Shrink the window if it's valid, count the total number of substring
            while (start < n && vowelPresentCount == 5 && consonantCount == k) {
                // Count the valid substrings produced by the current window
                totalCount += nextConsonant[end] - end;
                
                // Shrink the window from the left
                char startLetter = word.charAt(start);
                int startVowelIndex = vowelString.indexOf(startLetter);

                if (startVowelIndex != -1) {
                    vowelCount[startVowelIndex]--;
                    if (vowelCount[startVowelIndex] == 0) vowelPresentCount--;
                } else {
                    consonantCount--;
                }
                start++;
            }
        }

        return totalCount;
    }
}