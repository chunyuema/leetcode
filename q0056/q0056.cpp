class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());

        vector<vector<int>> res;
        int begin = intervals[0][0]; // to keep track of the beginning of each merged interval
        int end = intervals[0][1]; // to keep track of the end of each merged interval

        for (int i = 0; i < intervals.size(); ++i) {
            // if the beginning of the current interval (intervals[i][0]) is less than
            // the current endpoint (end), then merge it by updating the end with the max endpoint
            if (intervals[i][0] <= end) {
                end = max(intervals[i][1], end);
            } 
            // if the beginning of the current interval (intervals[i][0]) is greater than
            // the current endpoint(end), then don't merge it. Rather push the merged interval
            // and update the begin and endpoint with the current interval's begin and endpoint
            else {
                res.push_back({begin, end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // push the leftover last merged interval
        res.push_back({begin, end});
        return res;
    }
};