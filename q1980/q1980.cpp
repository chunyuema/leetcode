class Solution
{
public:
    string findDifferentBinaryString(vector<string> &nums)
    {
        int targetLen = nums[0].size();
        unordered_set<string> bsSet;
        for (const string &s : nums)
            bsSet.insert(s);
        return backtrack("", bsSet, targetLen);
    }

private:
    string backtrack(string curr, const unordered_set<string> &bsSet, int targetLen)
    {
        if (curr.size() == targetLen)
        {
            if (bsSet.find(curr) == bsSet.end())
                return curr;
            else
                return "";
        }

        // add zero to the current string
        string res0 = backtrack(curr + "0", bsSet, targetLen);
        if (res0.size() > 0)
            return res0;

        // add one to the current string
        string res1 = backtrack(curr + "1", bsSet, targetLen);
        return res1;
    }
};