class Solution
{
    static bool endTimeComparator(vector<int> &i1, vector<int> &i2)
    {
        return i1[1] < i2[1];
    }

public:
    int eraseOverlapIntervals(vector<vector<int>> &intervals)
    {
        sort(intervals.begin(), intervals.end(), endTimeComparator);
        int res = 0;
        int prevEndTime = INT_MIN;
        for (const auto &i : intervals)
        {
            int newStartTime = i[0];
            int newEndTime = i[1];
            if (newStartTime >= prevEndTime)
            {
                prevEndTime = newEndTime;
            }
            else
            {
                res++;
            }
        }
        return res;
    }
};