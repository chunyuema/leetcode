class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        char prevColor = colors.charAt(0);
        int prevCost = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            char currColor = colors.charAt(i);
            int currCost = neededTime[i];
            // If the current color is the same as previous color
            if (currColor == prevColor) {
                // Greedily remove the balloon with lower effort to minimize cost
                res += Math.min(prevCost, currCost);

                // Previous color will remain unchanged because we removed balloon of the same
                // color
                // Previous cost will change to take the higher value of prevCost and currCost
                prevCost = Math.max(currCost, prevCost);
            }
            // If the current color is not the same as previous color
            // Update the balloon to track a new balloon color instead
            else {
                prevColor = currColor;
                prevCost = currCost;
            }
        }
        return res;
    }
}