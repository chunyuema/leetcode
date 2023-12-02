class Solution
{
public:
    int countCharacters(vector<string> &words, string chars)
    {
        unordered_map<char, int> charCount;
        for (char c : chars)
            charCount[c]++;

        int res = 0;
        for (const string &word : words)
        {
            if (canForm(word, charCount))
                res += word.size();
        }

        return res;
    }

private:
    bool canForm(const string &word, unordered_map<char, int> &charCount)
    {
        unordered_map<char, int> wordCharCount;
        for (char c : word)
            wordCharCount[c]++;

        for (const auto &[c, count] : wordCharCount)
        {
            if (charCount[c] < count)
                return false;
        }
        return true;
    }
};