class Solution
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.size() != t.size())
            return false;

        vector<int> characterMapS(26);
        vector<int> characterMapT(26);
        for (int i = 0; i < s.size(); i++)
        {
            characterMapS[s[i] - 'a']++;
            characterMapT[t[i] - 'a']++;
        }

        return characterMapS == characterMapT;
    }
};