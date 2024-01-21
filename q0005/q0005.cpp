class Solution
{
public:
    string longestPalindromicSubstring(string str)
    {
        vector<int> currentL{0, 1};
        for (int i = 1; i < str.length(); i++)
        {
            vector<int> oddL = expandFromCenter(str, i, i);
            vector<int> evenL = expandFromCenter(str, i, i + 1);
            vector<int> longerL = oddL[1] - oddL[0] > evenL[1] - evenL[0] ? oddL : evenL;
            currentL = longerL[1] - longerL[0] > currentL[1] - currentL[0] ? longerL : currentL;
        }
        return str.substr(currentL[0], currentL[1] - currentL[0]);
    }

    vector<int> expandFromCenter(string str, int start, int end)
    {
        while (start >= 0 && end < str.length())
        {
            if (str[start] != str[end])
            {
                break;
            }
            else
            {
                start--;
                end++;
            }
        }
        return vector<int>{start + 1, end};
    }
};