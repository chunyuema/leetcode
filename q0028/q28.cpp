class Solution
{
public:
    int strStr(string haystack, string needle)
    {
        int len = needle.size();
        if (haystack.size() < len)
            return -1;
        for (int i = 0; i < haystack.size() - len + 1; i++)
        {
            if (string(haystack.begin() + i, haystack.begin() + i + len) == needle)
                return i;
        }
        return -1;
    }
};