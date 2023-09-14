class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long currSum = getSum(m, index, n);
            if (currSum > maxSum)
                r = m - 1;
            else
                l = m + 1;
        }
        return l - 1;
    }

    private long getSum(long val, int i, int n) {
        long sum = 0;
        if (val > i) {
            sum += (long) ((val + (val - i)) * (i + 1)) / 2;
        } else {
            sum += (long) ((val + 1) * val) / 2;
            sum += i - val + 1;
        }

        if (val >= n - i) {
            sum += (long) ((val + (val - n + 1 + i)) * (n - i)) / 2;
        } else {
            sum += (long) ((val + 1) * val) / 2;
            sum += n - val - i;
        }

        return sum - val;
    }
}