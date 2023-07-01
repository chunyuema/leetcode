#include <vector>
using namespace std;

class Solution
{
public:
    int distributeCookies(vector<int> &cookies, int k)
    {
        vector<int> cookieDistribution(k, 0);
        return distributeHelper(cookies, cookieDistribution, 0, k);
    }

    int distributeHelper(const vector<int> &cookies, vector<int> &cookieDistribution,
                         int currCookieIndex, int k)
    {

        if (currCookieIndex == cookies.size())
        {
            int unfairCookieDistribution = INT_MIN;
            for (int c : cookieDistribution)
            {
                unfairCookieDistribution = max(unfairCookieDistribution, c);
            }
            return unfairCookieDistribution;
        }

        int currMinUnfairCookieDistribution = INT_MAX;
        for (int j = 0; j < k; j++)
        {
            // Allocate the cookie to the j-th child
            // Recursively compute the new min unfair cookie distribution with the current allocation
            // Compare and update the curr min unfair cookie distribution
            cookieDistribution[j] += cookies[currCookieIndex];
            int newMinUnfairCookieDistribution = distributeHelper(cookies, cookieDistribution, currCookieIndex + 1, k);
            currMinUnfairCookieDistribution = min(currMinUnfairCookieDistribution, newMinUnfairCookieDistribution);

            // Dealloate the cookie to the j-th child to backtrack
            cookieDistribution[j] -= cookies[currCookieIndex];
        }
        return currMinUnfairCookieDistribution;
    }
};