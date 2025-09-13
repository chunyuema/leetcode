class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        int maxFreqVowel = 0;
        int maxFreqCosonant = 0;
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
            if ("aeiou".indexOf(c) != -1) {
                maxFreqVowel = Math.max(maxFreqVowel, counter.get(c));
            } else {
                maxFreqCosonant = Math.max(maxFreqCosonant, counter.get(c));
            }    
        }
        return maxFreqVowel + maxFreqCosonant;
    }
}
