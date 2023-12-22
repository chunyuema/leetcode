class Solution
{
public:
    int maxScore(string s)
    {
        int totalOnes = count(s.begin(), s.end(), '1');

        int left = s[0] == '1' ? 0 : 1;
        int right = s[0] == '1' ? totalOnes - 1 : totalOnes;
        int maxScore = left + right;
        for (int i = 1; i < s.size() - 1; i++)
        {
            if (s[i] == '1')
            {
                right--;
            }
            else
            {
                left++;
                maxScore = max(maxScore, left + right);
            }
        }
        return maxScore;
    }
};