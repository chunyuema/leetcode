class Solution
{
public:
    string sortVowels(string s)
    {
        string vowelString;
        for (const char c : s)
        {
            if (isVowel(c))
                vowelString += c;
        }
        sort(vowelString.begin(), vowelString.end());
        int i = 0;
        string res;
        for (const char c : s)
        {
            if (!isVowel(c))
                res += c;
            else
                res += vowelString[i++];
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