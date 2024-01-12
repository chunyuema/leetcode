class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int count = 0;
        int n = s.length();

        // Increment count in the first half
        for (int i = 0; i < n / 2; i++) {
            if (vowels.contains(s.charAt(i)))
                count++;
        }

        // Decrement count in the second half
        for (int i = n / 2; i < n; i++) {
            if (vowels.contains(s.charAt(i)))
                count--;
        }

        return count == 0;
    }
}