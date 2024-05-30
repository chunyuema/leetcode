class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int left_sum = 0;
        int right_sum = accumulate(nums.begin(), nums.end(), 0);
        
        for (int i = 0; i < nums.size(); ++i) {
            right_sum -= nums[i];
            if (right_sum == left_sum) {
                return i;
            }
            left_sum += nums[i];
        }
        
        return -1;
    }
};