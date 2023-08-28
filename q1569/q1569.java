class Solution {

    private long mod = (long) 1e9 + 7;

    private long[][] pascalTable;
    
    public int numOfWays(int[] nums) {
        // build the pascal table to quickly compute the C(total, leftNodes)
        int m = nums.length;
        pascalTable = new long[m][m];
        for (int i = 0; i < m; i++) pascalTable[i][0] = pascalTable[i][i] = 1;
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                pascalTable[i][j] = (pascalTable[i-1][j-1] + pascalTable[i-1][j]) % mod;
            }
        }

        // call on the dfsHelper
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int)((dfsHelper(arrList) - 1) % mod);
    }

    private long dfsHelper(List<Integer> nums) {
        if (nums.size() < 3) return 1;

        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(0)) leftNodes.add(nums.get(i));
            else rightNodes.add(nums.get(i));
        }

        // recursively get the number of ways to permute the left and right subtree
        long leftNumOfWays = dfsHelper(leftNodes) % mod;
        long rightNumOfWays = dfsHelper(rightNodes) % mod;

        // the total number of ways is the left * right * C(total-1, left).
        // C(total-1, left) represents finding the number of ways to interleave right subarray into the left without changing the relative order of them, so that the tree will not be disrupted
        return (((leftNumOfWays * rightNumOfWays) % mod) * pascalTable[nums.size()-1][leftNodes.size()]) % mod;
    }
}