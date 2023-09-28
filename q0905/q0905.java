class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0; 
        int r = nums.length - 1;
        int i = 0;
        while (l < r) {
            if (nums[i] % 2 == 0) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp; 
                l++;
                i++;
            } else {
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp; 
                r--;
            }
        } 
        return nums;
    }
}