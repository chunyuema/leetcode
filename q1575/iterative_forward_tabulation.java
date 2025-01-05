class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int N = locations.length;
        int MOD = 1000000007;

        // dp[i][j] will store the number of ways to reach location i with j units of fuel
        int[][] dp = new int[N][fuel + 1];

        // Initialize the start location (we can always start there with any fuelLeft)
        dp[start][fuel] = 1;

        // Iterate over all possible fuel values from the max fuel to zero fuel level
        for (int fuelLeft = fuel; fuelLeft >= 0; fuelLeft--) {
            // For each location, compute how many ways we can get there
            for (int currLoc = 0; currLoc < N; currLoc++) {
                // If no ways to get to this location with `fuelLeft`, skip it
                if (dp[currLoc][fuelLeft] == 0) continue;

                // Try moving to every other location
                for (int nextLoc = 0; nextLoc < N; nextLoc++) {
                    if (currLoc != nextLoc) {  // Can't stay in the same location
                        int fuelUsed = Math.abs(locations[currLoc] - locations[nextLoc]);

                        // If there's enough fuel to move to nextLoc
                        if (fuelLeft >= fuelUsed) {
                            dp[nextLoc][fuelLeft - fuelUsed] = (dp[nextLoc][fuelLeft - fuelUsed] + dp[currLoc][fuelLeft]) % MOD;
                        }
                    }
                }
            }
        }

        // Return the result, i.e., the number of ways to reach the finish location with any amount of fuelLeft
        int totalRoutes = 0;
        for (int fuelLeft = 0; fuelLeft <= fuel; fuelLeft++) {
            totalRoutes = (totalRoutes + dp[finish][fuelLeft]) % MOD;
        }
        
        return totalRoutes;
    }
}

