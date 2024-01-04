class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        int totalOps = 0;
        for (int count : numCount.values()) {
            // cannot be eliminated
            if (count == 1)
                return -1;

            // use the operation to eliminate as many groups of 3 as possible
            // only the left over 1 pair is eliminated with the operation to remove pair
            totalOps += count % 3 == 0 ? count / 3 : count / 3 + 1;
        }
        return totalOps;
    }
}