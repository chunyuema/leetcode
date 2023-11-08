class Solution {
    public int minMoves(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
        }

        int moveCount = 0;
        for (int num : nums) {
            moveCount += num - minNum;
        }

        return moveCount;
    }
}