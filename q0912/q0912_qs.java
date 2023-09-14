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

        // move the pivot number temporarily to the right most position
        swap(nums, m, r);

        // start from the left most position
        int p = l;
        for (int i = l; i < r; i++) {
            // if we find any number that is smaller than pivot number, move it to the left
            // most possible, increment the pivot position
            if (nums[i] <= pivot) {
                swap(nums, p, i);
                p++;
            }
        }

        // move the pivot back to position p, and return the pivot position
        swap(nums, p, r);
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}