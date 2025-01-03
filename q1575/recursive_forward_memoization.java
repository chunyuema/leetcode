class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] memo = new int[locations.length][fuel + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        return dpHelper(locations, start, finish, fuel, memo);
    }

    // Let dpHelper(currLoc, fuelLeft) represent the total number of ways from currLocation to destination 
    private int dpHelper(int[] locations, int currentLoc, int finish, int fuelLeft, int[][] memo) {
	
	// Base Case: If there is no fuel left: 0 ways in total 
        if (fuelLeft < 0) return 0;

	// Memoized Case: If dpHelper(currLoc, fuelLeft) has been determined before, return its value
        if (memo[currentLoc][fuelLeft] != -1) return memo[currentLoc][fuelLeft];
        
	// Total number of routes is equal to the sum of dpHelper(nextLoc, fuelLeft) for all nextLoc
        int totalRoutes = currentLoc == finish ? 1 : 0;
        for (int nextLoc = 0; nextLoc < locations.length; nextLoc++) {
            if (nextLoc != currentLoc) {
                int fuelUsed = Math.abs(locations[nextLoc] - locations[currentLoc]);
                totalRoutes = (totalRoutes + dpHelper(locations, nextLoc, finish, fuelLeft - fuelUsed, memo))
                        % 1000000007;
            }
        }

        memo[currentLoc][fuelLeft] = totalRoutes;
        return totalRoutes;
    }
}
