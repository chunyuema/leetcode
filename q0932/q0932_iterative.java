class Solution {
    public int[] beautifulArray(int n) {
        Map<Integer, int[]> dp = new HashMap<>();
        dp.put(0, new int[]{});
        dp.put(1, new int[]{1});
        for (int i = 2; i <= n; i++) {
            int[] left  = dp.get((i+1)/2);
            int[] right = dp.get(i/2);

            int[] res = new int[i];
            int j = 0;
            // fill the left with odd numbers
            for (int l : left) res[j++] = l * 2 - 1;
            // fill the right with even numbers
            for (int r : right) res[j++] = r * 2;
            dp.put(i, res);
        }
        return dp.get(n);
    }
}