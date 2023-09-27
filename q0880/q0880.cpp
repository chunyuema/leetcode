class Solution
{
public:
    string decodeAtIndex(string s, int k)
    {
        long long totalLen = 0;
        for (char c : s)
        {
            if (isdigit(c))
                totalLen *= c - '0';
            else
                totalLen++;
        }

        for (int i = s.size() - 1; i >= 0; i--)
        {
            char c = s[i];
            if (isdigit(c))
            {
                totalLen /= (c - '0');
                k = k % totalLen;
            }
            else
            {
                if (k == 0 || totalLen == k)
                    return string("") + c;
                totalLen--;
            }
        }
        return "";
    }
};