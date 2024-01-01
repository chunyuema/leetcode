class Solution
{
public:
    int findContentChildren(vector<int> &g, vector<int> &s)
    {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int kidIndex = 0;
        int cookieIndex = 0;
        while (kidIndex < g.size() && cookieIndex < s.size())
        {
            // try to use the smallest cookie to match the current kid with smallest greed
            if (s[cookieIndex] >= g[kidIndex])
            {
                kidIndex++;
            }
            // update the cookieIndex
            // case 1: satisfied the kid and need a new cookie for the next kid
            // case 2: kid's greed factor larger than current cookie, need a bigger cookie
            cookieIndex++;
        }
        return kidIndex;
    }
};