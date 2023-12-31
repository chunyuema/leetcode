class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLen = -1;
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (indexMap.containsKey(currChar)) {
                maxLen = Math.max(maxLen, i - indexMap.get(currChar) - 1);
            } else {
                indexMap.put(currChar, i);
            }
        }
        return maxLen;
    }
}