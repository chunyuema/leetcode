class Solution
{
public:
    int largestVariance(string s)
    {
        vector<int> counter(26, 0);
        for (char c : s)
        {
            counter[c - 'a']++;
        }

        int globalMax = 0;

        for (int i = 0; i < 26; i++)
        {
            for (int j = 0; j < 26; j++)
            {
                // If i, j are equal, or one of them is not present in the string s, skip this possibility
                if (i == j || counter[i] == 0 || counter[j] == 0)
                    continue;

                char majorChar = 'a' + i;
                char minorChar = 'a' + j;
                int majorCharCount = 0;
                int minorCharCount = 0;
                int minorCharRemaining = counter[j];

                for (char c : s)
                {
                    if (c == majorChar)
                    {
                        majorCharCount++;
                    }
                    else if (c == minorChar)
                    {
                        minorCharCount++;
                        minorCharRemaining--;
                    }

                    int localMax = majorCharCount - minorCharCount;
                    if (minorCharCount > 0)
                        globalMax = max(globalMax, localMax);
                    if (localMax < 0 && minorCharRemaining > 0)
                    {
                        majorCharCount = 0;
                        minorCharCount = 0;
                    }
                }
            }
        }
        return globalMax;
    }
};