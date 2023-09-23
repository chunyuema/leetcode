class Solution
{
public:
    int longestStrChain(vector<string> &words)
    {
        sort(words.begin(), words.end(), [](const string &s1, const string &s2)
             { return s1.size() < s2.size(); });

        vector<int> memo(words.size(), 0);

        int maxLen = 1;
        for (int i = 0; i < words.size(); i++)
        {
            maxLen = max(dpHelper(words, i, memo), maxLen);
        }
        return maxLen;
    }

    int dpHelper(const vector<string> &words, const int i, vector<int> &memo)
    {
        if (i == 0)
            return 1;
        if (memo[i] != 0)
            return memo[i];

        int ans = 1;
        for (int j = 0; j < i; j++)
        {
            if (isPredecessor(words[j], words[i]))
            {
                ans = max(ans, dpHelper(words, j, memo) + 1);
            }
        }

        memo[i] = ans;
        return ans;
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