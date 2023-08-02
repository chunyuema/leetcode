class Solution {
    public int[] sortArray(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSortHelper(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSortHelper(nums, l, m);
            mergeSortHelper(nums, m + 1, r);
            merge(nums, l, r, m);
        }
    }

    private void merge(int[] nums, int l, int r, int m) {
        int[] mergedNums = new int[r - l + 1];

        int i = l;
        int j = m + 1;
        int k = 0;

        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                mergedNums[k++] = nums[i++];
            } else {
                mergedNums[k++] = nums[j++];
            }
        }

        while (i <= m) {
            mergedNums[k++] = nums[i++];
        }

        while (j <= r) {
            mergedNums[k++] = nums[j++];
        }

        for (int p = 0, q = l; q <= r; p++, q++) {
            nums[q] = mergedNums[p];
        }
    }
}