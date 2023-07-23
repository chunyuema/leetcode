class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            // if the num > 0, we are seeing this idx first time
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
            // if the num < 0, we are seeing this idx for > 1 times
            else {
                duplicates.add(Math.abs(nums[i]));
            }
        }
        return duplicates;
    }
}