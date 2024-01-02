class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        // Use a count to track the frequency of each num
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        int totalNum = nums.length;

        // Process the nums until all numbers are processed
        while (totalNum > 0) {
            // For every row in the matrix
            List<Integer> currRow = new ArrayList<>();

            // Loop through all the candidates keys (keys are unique so no duplications)
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int num = entry.getKey();
                int numCount = entry.getValue();

                // Greedily add num because we want the number of rows in the 2D array should be
                // minimal
                // This means that as many elements in one row as possible starting from the
                // first row
                if (numCount > 0) {
                    currRow.add(num);
                    totalNum--;
                    count.put(num, numCount - 1);
                }
            }
            res.add(currRow);
        }
        return res;
    }
}