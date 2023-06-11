class Solution
{
public:
    int appendCharacters(string s, string t)
    {
        int ps = 0;
        int pt = 0;
        while (ps != s.size() && pt != t.size())
        {
            if (s[ps] == t[pt])
            {
                pt++;
            }
            ps++;
        }
        return t.size() - pt;
    }
};