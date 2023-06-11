class Solution
{
public:
    int maximumUnits(vector<vector<int>> &boxTypes, int truckSize)
    {
        sort(boxTypes.begin(), boxTypes.end(), [](auto const &a, auto const &b)
             { return a[1] > b[1]; });
        int res = 0;
        int i = 0;
        int n = boxTypes.size();
        while (i < n && truckSize > 0)
        {
            res += min(boxTypes[i][0], truckSize) * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            i++;
        }
        return res;
    }
};