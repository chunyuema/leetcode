class Solution
{
public:
    int minOperations(string s)
    {
        int ops = 0;

        // start with whatever that is in the first position
        int prevChar = s[0];
        for (int i = 1; i < s.size(); i++)
        {
            char currChar = s[i];
            if (prevChar == currChar)
            {
                ops++;
                prevChar = prevChar == '1' ? '0' : '1';
            }
            else
            {
                prevChar = currChar;
            }
        }
        return min(ops, (int)s.size() - ops);
    }
};