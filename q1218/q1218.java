class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int longestLen = 1;
        // memo[i] = longest subsequence until int i with the given difference
        Map<Integer, Integer> memo = new HashMap<>();
        for (int currInt : arr) {
            int targetInt = currInt - difference;
            // If the targetInt has appeared before, get the longest subsequence len
            // If the targetInt has not appeared before, get 0 as the previous longest is 0
            // The new len is previous len + 1, and then update the dp map, as well as the
            // result
            int currLen = memo.getOrDefault(targetInt, 0) + 1;

            memo.put(currInt, currLen);
            longestLen = Math.max(longestLen, currLen);
        }
        return longestLen;
    }
}