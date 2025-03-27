class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        int prev = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int curr = grid[i][j];
                if ((curr - prev) % x != 0) return -1; 
                nums.add(grid[i][j]);
            }
        }

        Collections.sort(nums);
        
        // Final common number would be the median:
        int median = nums.get(nums.size() / 2);
        int minOps = 0;
        for (int num : nums) {
            minOps += Math.abs(num - median) / x;
        }
        return minOps;
    }
}

