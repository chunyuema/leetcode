class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        // Use an int array to track the min row that num can join
        // This is okay because 1 <= nums[i] <= nums.length
        int[] rowIndex = new int[nums.length + 1];

        List<List<Integer>> res = new ArrayList<>();
        for (int num : nums) {
            // Check which row num should be part of
            int index = rowIndex[num];

            // If the row has not been created, do so
            if (index >= res.size())
                res.add(new ArrayList<>());

            // Add the num to the corresponding row
            res.get(index).add(num);

            // Update the min row that the same num can go to
            // This avoids adding number repeatedly to the same row
            rowIndex[num]++;
        }

        return res;
    }
}