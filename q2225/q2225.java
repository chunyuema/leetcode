class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] records = new int[100001];
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // We only need to mark the winner with 1 because we do not care how many times
            if (records[winner] == 0)
                records[winner] = 1;

            // If records[loser] == 1, this loser has been winning in the previous matches
            // Flip the record to -1 to indicate that this person has lost once
            if (records[loser] == 1)
                records[loser] = -1;
            // If records[loser] is not 1, then the loser could have lost either zero /
            // multiple times
            // Simply decrement the number of losses to track how many the person has lost
            else
                records[loser]--;
        }

        List<Integer> zeroLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();
        for (int i = 0; i < 100001; i++) {
            if (records[i] == 1)
                zeroLost.add(i);
            else if (records[i] == -1)
                oneLost.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(zeroLost);
        res.add(oneLost);
        return res;
    }
}