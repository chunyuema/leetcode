class Solution
{
public:
    int arrangeCoins(int n)
    {
        int l = 0;
        int r = n;
        while (l <= r)
        {
            long m = (l + r) / 2;
            /* set l to be m+1 even if we find m, this is because we want to find the largest m possible */
            if (m * (m + 1) / 2 <= n)
            {
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }
        return l - 1;
    }
};