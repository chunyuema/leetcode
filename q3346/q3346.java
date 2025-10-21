public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        int minVal = nums[0];
        int maxVal = nums[nums.length - 1];

        for (int target = minVal; target <= maxVal; target++) {
            int rangeCount = getRange(nums, target, k);
            int existing = counter.getOrDefault(target, 0);
            int currFreq = Math.min(rangeCount, existing + numOperations);
            maxFreq = Math.max(maxFreq, currFreq);
        }

        return maxFreq;
    }

    // Helper: counts how many numbers are within [target - k, target + k]
    private int getRange(int[] nums, int target, int k) {
        int left = lowerBound(nums, target - k);
        int right = upperBound(nums, target + k);
        return right - left;
    }

    // Equivalent of Python's bisect_left
    private int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // Equivalent of Python's bisect_right
    private int upperBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

