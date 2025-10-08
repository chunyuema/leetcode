class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        int n = potions.length;

        for (int i = 0; i < spells.length; i++) {
            int s = spells[i];
            int idx = bs(potions, s, success);
            if (idx != -1) res[i] = n - idx;
        }

        return res;
    }

    private int bs(int[] sortedPotions, long spell, long success) {
        int l = 0; 
        int h = sortedPotions.length - 1; 
        int idx = -1;
        while (l <= h) {
            int m = l + (h - l) / 2; 
            if ((long) sortedPotions[m]  * spell >= success) {
                idx = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return idx;
    }
}

