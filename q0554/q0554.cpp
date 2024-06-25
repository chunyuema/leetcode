class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        unordered_map<int, int> tracker;
        int maxCount = 0;
        
        for (const auto& row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; ++i) {
                sum += row[i];
                tracker[sum]++;
                maxCount = max(maxCount, tracker[sum]);
            }
        }
        
        return wall.size() - maxCount;
    }
};