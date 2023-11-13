class Solution
{
public:
    string sortVowels(string s)
    {
        unordered_map<char, int> vowelCount;
        for (const char c : s)
        {
            if (isVowel(c))
                vowelCount[c]++;
        }

        string sortedVowel = "AEIOUaeiou";
        string res;
        int i = 0;
        for (const char c : s)
        {
            if (!isVowel(c))
                res += c;
            else
            {
                while (vowelCount[sortedVowel[i]] == 0)
                    i++;
                res += sortedVowel[i];
                vowelCount[sortedVowel[i]]--;
            }
        }
        return res;
    }

private:
    bool isVowel(const char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
};