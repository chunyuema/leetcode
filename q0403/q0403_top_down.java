class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> locs = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            locs.put(stones[i], i);
        }
        
        int[][] memo = new int[stones.length + 1][stones.length + 1];
        for (int[] r : memo) Arrays.fill(r, -1);

        return dpHelper(stones, locs, memo, 0, 0);
    }

    private boolean dpHelper(int[] stones, Map<Integer, Integer> locs, int[][] memo, int i, int prevJump) {
        if (i == stones.length -1) return true;
        if (memo[i][prevJump] != -1) return memo[i][prevJump] == 1;

        boolean res = false;
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            int nextLoc = stones[i] + nextJump;
            if (nextJump > 0 && locs.containsKey(nextLoc)) {
                res = res || dpHelper(stones, locs, memo, locs.get(nextLoc), nextJump);
            }
        }
        
        memo[i][prevJump] =  res ? 1 : 0;
        return res;
    }
}