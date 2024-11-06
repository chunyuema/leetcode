class Solution {
    public boolean canSortArray(int[] nums) {
       int n = nums.length;

       int[] updatedNums = Arrays.copyOf(nums, n);

       // Move the large numbers to the right as much as possible 
       for (int i = 0; i < n - 1; i++) {
            if (updatedNums[i + 1] < updatedNums[i]) {
                if (Integer.bitCount(updatedNums[i + 1]) == Integer.bitCount(updatedNums[i])) {
                    int tmp = updatedNums[i + 1];
                    updatedNums[i + 1] = updatedNums[i];
                    updatedNums[i] = tmp;
                } else {
                    // If they cannot be swapped, there is no way they can ever be swapped into the right order
                    return false;
                }
            } else {
                continue;
            }
       }

       // Move the small numbers to the left as much as possible
       for (int i = n-1; i > 0; i--) {
            if (updatedNums[i - 1] > updatedNums[i]) {
                if (Integer.bitCount(updatedNums[i - 1]) == Integer.bitCount(updatedNums[i])) {
                    int tmp = updatedNums[i - 1];
                    updatedNums[i - 1] = updatedNums[i];
                    updatedNums[i] = tmp;
                } else {
                    // If they cannot be swapped, there is no way they can ever be swapped into the right order
                    return false;
                }
            } else {
                continue;
            }
       }

       return true;
    }
}


