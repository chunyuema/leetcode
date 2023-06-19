class Solution
{
public:
    double myPow(double x, int n)
    {
        return helper(x, (long)n);
    }

    double helper(double x, long n)
    {
        if (n == 0)
            return 1;
        if (n < 0)
            return helper(1 / x, -1 * n);

        double res = helper(x * x, n / 2);
        if (n % 2 != 0)
        {
            res *= x;
        }
        return res;
    }
};