class Solution {
    public int minDeletions(String s) {
        // Get the frequency of all the characters
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar))
                map.put(currChar, map.get(currChar) + 1);
            else
                map.put(currChar, 1);
        }

        // Use freqSet to track all the unique frequencies
        Set<Integer> freqSet = new HashSet<>();
        int totalDeletion = 0;
        for (Integer freq : map.values()) {

            // For all the frequencies recorded, delete until the largest non-taken
            // frequency is reached (freq = 0 can be taken multiple times as we do not care)
            while (freqSet.contains(freq) && freq > 0) {
                freq--;
                totalDeletion++;
            }

            // Add this frequency to the frequency set so we do not use it again
            freqSet.add(freq);
        }
        return totalDeletion;
    }
}