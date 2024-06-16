class Solution {
public:
    int twoPointer(const vector<int>& nums, int diff) {
        int l = 0, r = 1, cnt = 0;
        for (l = 0; l < nums.size(); ++l) {
            while (r < nums.size() && nums[r] - nums[l] <= diff) {
                ++r;
            }
            r--;
            cnt += (r - l);
        }
        return cnt;
    }

    int binarySearch(const vector<int>& nums, int k, int max_diff) {
        int l = 0, r = max_diff;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = twoPointer(nums, mid);
            if (cnt >= k) { // even though cnt == k, we keep going because there could be smaller diff values e.g. [1, 1, 3]
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l; // does matter
    }
    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        
        int max_diff = nums.back() - nums.front();
        
        return binarySearch(nums, k, max_diff);
    }

};