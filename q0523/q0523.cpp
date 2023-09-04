class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        map<int, int> d; 
        d[0] = -1;
        int prefix_sum = 0;
        for (int i = 0; i < nums.size(); i++){
            int num = nums[i]; 
            prefix_sum += num;
            int mod_k = prefix_sum % k; 
            if (d.find(mod_k) != d.end()){
                if (i - d[mod_k] >= 2) return true;
            } else {
                d[mod_k] = i;
            }
        }
        return false;
    }
};