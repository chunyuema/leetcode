class Solution {
    public boolean winnerOfGame(String colors) {
        int movesForAlice = 0;
        int movesForBob = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1) &&
                    colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A')
                    movesForAlice++;
                else
                    movesForBob++;
            }
        }
        return movesForAlice > movesForBob;
    }
}