class Solution {
    public int[] sortArray(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSortHelper(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            quickSortHelper(nums, l, p - 1);
            quickSortHelper(nums, p + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int m = l + (r - l) / 2;
        int pivot = nums[m];
        swap(nums, m, r);
        int p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, p, i);
                p++;
            }
        }
        swap(nums, p, r);
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}