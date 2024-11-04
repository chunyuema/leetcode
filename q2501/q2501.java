class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> streakLens = new HashMap<>();
        Arrays.sort(nums);

        int maxLen = 1;
        for (int num : nums) {
            int root = (int) Math.sqrt(num);

            // If perfect square + is end of a previous streak
            if (root * root == num && streakLens.containsKey(root)) {
                int streakLen = streakLens.get(root) + 1; 
                streakLens.put(num, streakLen);
                maxLen = Math.max(streakLen, maxLen);
            } else {
                streakLens.put(num, 1);
            }
        }

        return maxLen == 1 ? -1 : maxLen;
    }
}
