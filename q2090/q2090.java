package q2090;

import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0)
            return nums;

        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        if (n < 2 * k + 1)
            return averages;

        long currentSum = 0;
        for (int i = 0; i <= 2 * k; i++) {
            currentSum += nums[i];
        }
        averages[k] = (int) (currentSum / (2 * k + 1));

        for (int j = k + 1; j < n - k; j++) {
            int l = j - k - 1;
            int r = j + k;
            currentSum -= nums[l];
            currentSum += nums[r];
            averages[j] = (int) (currentSum / (2 * k + 1));
        }
        return averages;
    }
}
