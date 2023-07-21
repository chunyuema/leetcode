class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dpLen = new int[nums.length];
        int[] dpCount = new int[nums.length];
        Arrays.fill(dpLen, 1);
        Arrays.fill(dpCount, 1);
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int newMaxLen = dpLen[j] + 1;
                    // if the new max len is larger than the curr max len until i
                    // update the max len, but reset the total count of sub seq  
                    if (newMaxLen > dpLen[i]) {
                        dpLen[i] = newMaxLen;
                        dpCount[i] = 0;
                    }
                    // if the new max len is equal to the curr max len until i
                    // update the total count of sub seq at i with total count till j
                    if (newMaxLen == dpLen[i]) {
                        dpCount[i] += dpCount[j];
                    }
                }
            }
            maxLen = Math.max(dpLen[i], maxLen);
        }

        int numerOfLIS = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dpLen[i] == maxLen) {
               numerOfLIS += dpCount[i];
            }
        }

        return numerOfLIS;
    }
}