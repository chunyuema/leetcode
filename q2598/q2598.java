class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        for (int num : nums) {
            int remainder = ((num % value) + value) % value;
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        int start = 0; 
        while (remainderCount.getOrDefault(start % value, 0) > 0) {
            remainderCount.put(start % value, remainderCount.get(start % value) - 1);
            start++;
        }
        return start; 
    }
}
