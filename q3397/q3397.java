class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinct = 0;
        int prevMin = Integer.MIN_VALUE; 
        for (int num : nums) {
            int currMin = Math.min(Math.max(num - k, prevMin + 1), num + k);
            if (currMin > prevMin) {
                distinct++;
                prevMin = currMin;
            }
        }
        return distinct;
    }
}
