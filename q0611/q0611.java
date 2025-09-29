class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int total = 0; 

        int i;  
        int j; 
        for (int k = nums.length -1; k > 1; k--) {
            i = 0; 
            j = k-1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    total += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return total;
    }
}