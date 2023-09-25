class Solution
{
public:
    char findTheDifference(string s, string t)
    {
        char res = 0;

        // through ^= operation, repeated characters from s and from t will become zero bits, countering each other's effect
        for (char c : s)
            res ^= c;
        for (char c : t)
            res ^= c;
        return res;
    }
};