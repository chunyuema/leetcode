class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        // Initialize the counts
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        int i = 0;
        int j = 0;
        while (j < s1.length()) {
            s1Map[s1.charAt(j) - 'a']++;
            s2Map[s2.charAt(j) - 'a']++;
            j++;
        }
        
        // Iterate through s2 and update s2Map
        // At any given moment if the count map matches
        // We have found a valid permutation
        while (j < s2.length()) {
            if (isPermutation(s1Map, s2Map)) return true;
            s2Map[s2.charAt(j) - 'a']++;
            j++;
            
            s2Map[s2.charAt(i) - 'a']--;
            i++;
        }
        return isPermutation(s1Map, s2Map);
    }
    
    // This method will tell if two arrays have
    // Same characters of the same counts
    private boolean isPermutation(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) return false;
        }
        return true;
    }
}