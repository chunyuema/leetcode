class Solution
{
public:
    int totalMoney(int n)
    {
        // compute the total money for full weeks
        int fullWeekNum = n / 7;
        int first = 28;
        int last = 28 + 7 * (fullWeekNum - 1);
        int fullWeekTotal = (first + last) * fullWeekNum / 2;

        // compute the money for the left over days
        int lastWeekTotal = 0;
        for (int i = 1 + fullWeekNum; i < 1 + fullWeekNum + n % 7; i++)
        {
            lastWeekTotal += i;
        }
        return fullWeekTotal + lastWeekTotal;
    }
};