class Solution
{
public:
    bool arrayStringsAreEqual(vector<string> &word1, vector<string> &word2)
    {
        int wp1 = 0;
        int sp1 = 0;

        int wp2 = 0;
        int sp2 = 0;

        while (wp1 < word1.size() && wp2 < word2.size())
        {
            if (word1[wp1][sp1] != word2[wp2][sp2])
                return false;

            sp1++;
            if (sp1 == word1[wp1].size())
            {
                wp1++;
                sp1 = 0;
            }

            sp2++;
            if (sp2 == word2[wp2].size())
            {
                wp2++;
                sp2 = 0;
            }
        }

        return wp1 == word1.size() && wp2 == word2.size();
    }
};