class Solution {
    public List<Integer> partitionLabels(String s) {

        // Track the last index where the character appears in the string
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // Check the lastest index that current char appears
            int lastIndex = indexMap.get(s.charAt(i));

            // If the curr char appears later, then we cannot break yet
            right = Math.max(right, lastIndex);

            // Whenever i == right, we know all characters before i appear before right
            // Greedily add the chunk into the res to maximize the number of arrays
            // There is no point explore further as this is the earliest possible time
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }
        return res;
    }
}