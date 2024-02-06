class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            // Get the key that is used to group the strings
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add the string to the relevant group
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        res.addAll(groups.values());
        return res;
    }
}