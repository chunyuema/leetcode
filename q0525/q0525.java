class Solution {
    public int findMaxLength(int[] nums) {
        int prefixCountSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            // Increment the prefixCountSum by 1 if current number is 1
            // Decrement the prefixCountSum by 1 if current number is -1
            prefixCountSum += (nums[i] == 1) ? 1 : -1;

            // If previously, we have seen a prefixCountSum of the same
            if (map.containsKey(prefixCountSum)) {
                // From previous index j to current index i, the number of 1 and 0 must be equal
                int j = map.get(prefixCountSum);
                // Update the maxLen with a potentially larger length
                maxLen = Math.max(maxLen, i - j);
            } else {
                map.put(prefixCountSum, i);
            }
        }
        return maxLen;
    }
}