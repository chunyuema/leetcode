class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> seqSet = new HashSet<>();
        int[] used = new int[tiles.length()];
        backtrackHelper(tiles, seqSet, new StringBuilder(), used);
        return seqSet.size() - 1;
    }

    private void backtrackHelper(String tiles, Set<String> seqSet, StringBuilder temp, int[] used) {
        seqSet.add(temp.toString());
        for (int i = 0; i < tiles.length(); i++) {
            if (used[i] != 0)
                continue;
            temp.append(tiles.charAt(i));
            used[i] = 1;
            backtrackHelper(tiles, seqSet, temp, used);
            temp.deleteCharAt(temp.length() - 1);
            used[i] = 0;
        }
    }
}