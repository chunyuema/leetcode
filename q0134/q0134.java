package q0134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int[] balance = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            int b = gas[i] - cost[i];
            sum += b;
            balance[i] = b;
        }

        if (sum < 0)
            return -1;

        int res = 0;
        int currBalance = 0;
        for (int i = 0; i < balance.length; i++) {
            currBalance += balance[i];
            if (currBalance < 0) {
                res = i + 1;
                currBalance = 0;
            }
        }

        return res;
    }
}