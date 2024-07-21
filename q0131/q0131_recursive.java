class Solution {
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return dpHelper(s, 0, memo);
    }

    private List<List<String>> dpHelper(String s, int start, Map<Integer, List<List<String>>> memo) {
        // Base case: If 'start' is beyond or at the end of 's', return [[]] (empty partition)
        if (start >= s.length()) {
            List<List<String>> emptyResult = new ArrayList<>();
            emptyResult.add(new ArrayList<>());
            return emptyResult;
        }

        // Memoization check: If results for 'start' index are already computed, return them
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<List<String>> res = new ArrayList<>();
        
        // Iterate over all possible end indices 'i' to partition 's' starting from 'start'
        for (int i = start + 1; i <= s.length(); i++) {
            String currStr = s.substring(start, i); // Current substring to consider
            if (isPalindrome(currStr)) {
                // Recursively find partitions for substring starting from index 'i'
                List<List<String>> partitions = dpHelper(s, i, memo);
                // Add 'currStr' to the beginning of each partition found
                for (List<String> partition : partitions) {
                    List<String> newPartition = new ArrayList<>(partition);
                    newPartition.add(0, currStr);
                    res.add(newPartition);
                }
            }
        }

        // Memoize the result for 'start' index
        memo.put(start, res);
        return res;
    }

    // Utility method to check if a string is a palindrome
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
