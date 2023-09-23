class Solution
{
public:
    int longestStrChain(vector<string> &words)
    {
        sort(words.begin(), words.end(), [](const string &s1, const string &s2)
             { return s1.size() < s2.size(); });

        const int n = words.size();
        int dp[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;
        int maxLen = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (isPredecessor(words[j], words[i]))
                {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            maxLen = max(dp[i], maxLen);
        }
        return maxLen;
    }

    bool isPredecessor(const string &s1, const string &s2)
    {
        if (s1.size() + 1 != s2.size())
            return false;
        int p1 = 0;
        int p2 = 0;
        while (p2 < s2.size())
        {
            if (p1 < s1.size() && s1[p1] == s2[p2])
            {
                p1++;
                p2++;
            }
            else
            {
                p2++;
            }
        }
        return p1 + 1 == p2;
    }
};