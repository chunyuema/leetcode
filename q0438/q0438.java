class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        
        int[] charFreqS = new int[26];
        int[] charFreqP = new int[26];

        // initialze the initial state of the window
        for (int i = 0; i < p.length(); i++) {
            charFreqS[s.charAt(i) - 'a'] ++;
            charFreqP[p.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(charFreqS, charFreqP)) res.add(0);


        int l = 0; 
        int r = p.length()-1;
        while (r < s.length()-1) {
            // adjust the window & update state
            r++;
            charFreqS[s.charAt(r) - 'a'] ++;
            charFreqS[s.charAt(l) - 'a'] --;
            l++;
            // check if the state satisfies the condition + add to res
            if (Arrays.equals(charFreqS, charFreqP)) res.add(l);
        }

        return res;
    }
}