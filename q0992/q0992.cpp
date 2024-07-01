class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        unordered_map<int, int> cnt;
        int l_far = 0, l_near = 0;
        int res = 0;

        for (int r = 0; r < nums.size(); ++r) {
            cnt[nums[r]]++;
            while (cnt.size() > k) {
                cnt[nums[l_near]]--;
                if (cnt[nums[l_near]] == 0) {
                    cnt.erase(nums[l_near]);
                }
                l_near++;
                l_far = l_near;
            }
            while (cnt[nums[l_near]] > 1) {
                cnt[nums[l_near]]--;
                l_near++;
            }
            if (cnt.size() == k) {
                res += (l_near - l_far + 1);
            }
        }
        return res;
    }
};