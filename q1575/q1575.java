package q1575;

import java.util.Arrays;

class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] memo = new int[locations.length][fuel + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        return dpHelper(locations, start, finish, fuel, memo);
    }

    private int dpHelper(int[] locations, int currentLoc, int finish, int fuelLeft, int[][] memo) {
        if (fuelLeft < 0)
            return 0;
        if (memo[currentLoc][fuelLeft] != -1)
            return memo[currentLoc][fuelLeft];

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