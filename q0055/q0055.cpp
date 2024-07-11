class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size() == 1) {
            return true;
        }
        
        // the index that needs to be reached
        int target = nums.size() - 1;
        
        for (int i = nums.size() - 2; i >= 0; --i) {
            if (target - i <= nums[i]) {
                target = i;
            }
        }
        
        return target == 0;
    }
};