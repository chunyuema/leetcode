class Solution
{
public:
    string reverseWords(string s)
    {
        string s2 = s;
        int start = 0;

        for (int i = 0; i < s2.size(); i++)
        {
            if (s2[i] == ' ' || i == s2.size() - 1)
            {
                int end = i;
                if (i == s2.size() - 1 && s2[i] != ' ')
                    end++;
                reverse(s2, start, end);
                start = i + 1;
            }
        }

        return s2;
    }

private:
    void reverse(string &s, int start, int end)
    {
        while (start < end)
        {
            swap(s[start], s[end - 1]);
            start++;
            end--;
        }
    }
};