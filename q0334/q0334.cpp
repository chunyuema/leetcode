class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        long long minFirst, minSec;
        minFirst = numeric_limits<long long>::max();
        minSec = numeric_limits<long long>::max() - 1;
        for(int i = 0; i < nums.size(); i ++){
            if(nums[i] < minFirst){
                minFirst = nums[i];
            }
            else if(nums[i] > minFirst && nums[i] < minSec){
                minSec = nums[i];
            }
            else if(nums[i] > minSec){
                return true;
            }
        }
        return false;
    }
};