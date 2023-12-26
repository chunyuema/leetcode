class Solution
{
public:
    string largestGoodInteger(string num)
    {
        string result = "";
        for (int i = 2; i < num.size(); i++)
        {
            if (num[i - 2] == num[i] && num[i - 1] == num[i])
            {
                if (result.size() == 0 || result[0] < num[i])
                {
                    result = string(3, num[i]);
                }
            }
        }
        return result;
    }
};