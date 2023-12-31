class Solution
{
public:
    int maxLengthBetweenEqualCharacters(string s)
    {
        unordered_map<char, int> indexMap;
        int maxLen = -1;
        for (int i = 0; i < s.size(); i++)
        {
            if (indexMap.find(s[i]) != indexMap.end())
            {
                maxLen = max(maxLen, i - indexMap[s[i]] - 1);
            }
            else
            {
                indexMap[s[i]] = i;
            }
        }
        return maxLen;
    }
};