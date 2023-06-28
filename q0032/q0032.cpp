#include <string>
#include <vector>
using namespace std;

class Solution
{
public:
    int longestValidParentheses(string s)
    {
        int longestLength = 0;
        vector<int> dp(s.size(), 0);
        for (int i = 1; i < s.size(); i++)
        {
            if (s[i] == ')')
            {
                if (s[i - 1] == '(')
                {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                }
                else
                {
                    int potentialMatchOpen = i - dp[i - 1] - 1;
                    if (potentialMatchOpen >= 0 && s[potentialMatchOpen] == '(')
                    {
                        dp[i] = dp[i - 1] + 2;
                        dp[i] += (potentialMatchOpen - 1 >= 0 ? dp[potentialMatchOpen - 1] : 0);
                    }
                }
                longestLength = max(longestLength, dp[i]);
            }
        }
        return longestLength;
    }
};