class Solution
{
public:
    bool makeEqual(vector<string> &words)
    {
        unordered_map<char, int> charMap;
        for (const string &word : words)
        {
            for (const char c : word)
            {
                charMap[c]++;
            }
        }

        int expectedCount = words.size();
        for (auto &[key, val] : charMap)
        {
            if (val % expectedCount != 0)
                return false;
        }
        return true;
    }
};