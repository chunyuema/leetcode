class Solution
{
public:
    bool isSubsequence(string s, string t)
    {
        int ps = 0;
        int pt = 0;
        while (ps < s.size() && pt < t.size())
        {
            if (s[ps] == t[pt])
            {
                ps++;
            }
            pt++;
        }
        return ps == s.size();
    }
};