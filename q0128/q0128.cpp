class Solution {
public:
     int longestConsecutive(vector<int>& nums) {
        unordered_set<int> numSet(nums.begin(), nums.end());
        int max_len = 0;
        int length = 0;
        
        for (const int& num : numSet) {
            int l = 0;
            if (numSet.find(num - 1) == numSet.end()) {
                int currentNum = num;
                while (numSet.find(currentNum + length) != numSet.end()) {
                    length++;
                }
                max_len = std::max(max_len, length);
                length = 0;
            }
        }
        return max_len;
    }
};