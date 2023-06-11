package q0189;

class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        int[] temp = new int[l];

        int j = 0;
        for (int i = l - k; i < l; i++) {
            temp[j++] = nums[i];
        }

        for (int i = 0; i < l - k; i++) {
            temp[j++] = nums[i];
        }

        for (int i = 0; i < l; i++) {
            nums[i] = temp[i];
        }
    }
}