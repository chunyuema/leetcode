class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int numOfPairs = 0;
        for (int key : freqMap.keySet()) {
            if (k == 0 && freqMap.get(key) > 1) {
                numOfPairs++;
            } else if (k > 0 && freqMap.containsKey(key + k)) {
                numOfPairs++;
            }
        }
        return numOfPairs;
    }
}