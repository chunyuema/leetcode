class Solution {
    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar))
                map.put(currChar, map.get(currChar) + 1);
            else
                map.put(currChar, 1);
        }

        int oddCount = 0;
        int evenCount = 0;
        for (int count : map.values()) {
            oddCount += (count % 2);
            evenCount += (count / 2);
        }

        // if we have more than k odd number characters => impossible
        if (oddCount > k)
            return false;
        // if we use all the even and odd character, but still cannot make enough
        // palindromes => impossible
        if (2 * evenCount + oddCount < k)
            return false;

        return true;
    }
}