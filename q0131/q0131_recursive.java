class Solution {
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return dpHelper(s, 0, memo);
    }

    private List<List<String>> dpHelper(String s, int start, Map<Integer, List<List<String>>> memo) {
        if (start >= s.length()) {
            List<List<String>> emptyResult = new ArrayList<>();
            emptyResult.add(new ArrayList<>()); // Base case: return [[]] for empty string
            return emptyResult;
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = start + 1; i <= s.length(); i++) { // Iterate up to <= s.length() to include whole string
            String currStr = s.substring(start, i);
            if (isPalindrome(currStr)) {
                List<List<String>> partitions = dpHelper(s, i, memo);
                for (List<String> partition : partitions) {
                    List<String> newPartition = new ArrayList<>(partition);
                    newPartition.add(0, currStr); // Add current palindrome to the beginning of each partition
                    res.add(newPartition);
                }
            }
        }
        memo.put(start, res);
        return res;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
