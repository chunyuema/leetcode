class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = 0;
        int currFull = numBottles;
        int currEmpty = 0;
        while (currFull != 0 || currEmpty >= numExchange) {
            // greedy - try to exchange whenever possible
            if (currEmpty >= numExchange) {
                currFull++;
                currEmpty -= numExchange;
                numExchange++;
            }

            // drink all water
            currEmpty += currFull;
            res+=currFull;
            currFull = 0;
        }
        return res;
    }
}
