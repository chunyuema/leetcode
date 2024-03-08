class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> numFrequency = new HashMap<>();
        int maxFrequency = 0;
        int totalFrequency = 0;

        for (int num : nums) {
            // Update the numFrequency
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);

            // If currFrequency is larger than maxFrequency
            // Reset maxFrequency and totalFrequency
            int currFrequency = numFrequency.get(num);
            if (currFrequency > maxFrequency) {
                maxFrequency = currFrequency;
                totalFrequency = currFrequency;
            }
            // If currFrequency is the same the maxFrequency
            // Continue accruing the totalFrequency
            else if (currFrequency == maxFrequency) {
                totalFrequency += currFrequency;
            }
        }

        return totalFrequency;
    }
}