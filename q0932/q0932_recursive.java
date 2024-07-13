class Solution {
    public int[] beautifulArray(int n) {
        Map<Integer, int[]> memo = new HashMap<>();
        memo.put(1, new int[]{1});
        return dpHelper(n, memo);
    }

    // Let dpHelper(n) return the beautiful array of length n
    private int[] dpHelper(int n, Map<Integer, int[]>memo) {
        // Base case: when n = 1: covered in memoized case of memo[1]

        // Memoized case: 
        if (memo.containsKey(n)) return memo.get(n);

        // Recursive step: 
        int[] left  = dpHelper((n+1)/2, memo);
        int[] right = dpHelper(n/2, memo);
        int[] res = new int[n];

        int i = 0;
        // fill the left with odd numbers
        for (int l : left) res[i++] = l * 2 - 1;
        // fill the right with even numbers
        for (int r : right) res[i++] = r * 2;

        memo.put(n, res);
        return res;
    }
}