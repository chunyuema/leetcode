class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        
        int[] saves = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            final int[] cost = costs[i];
            // Send everyone to city a first
            minCost += cost[0];
            // Track how much money we would save if we send then to b instead
            saves[i] = cost[1] - cost[0];
        }
        
        // Sort the saves and get the maximum save at the beginning
        Arrays.sort(saves);
        for (int i = 0; i < costs.length / 2; i++) {
            // Send them to b instead to save the money
            minCost += saves[i];
        }
        
        return minCost;
    }
}