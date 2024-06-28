class Solution {
public:
    int binarySearch(const vector<int>& nums) {
        int l = 0;
        int r = nums.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0) {
                l = mid + 1;
            } else if (nums[mid] > 0) {
                r = mid - 1;
            } else {
                return nums[mid];
            }
        }
        if (abs(nums[l]) < abs(nums[r])) {
            return nums[l];
        } else if (abs(nums[l]) > abs(nums[r])) {
            return nums[r];
        } else {
            return max(nums[l], nums[r]);
        }
    }
    int findClosestNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        if (0 < nums[0]) {
            return nums[0];
        }
        if (0 > nums[nums.size() - 1]) {
            return nums[nums.size() - 1];
        }
        return binarySearch(nums);
    }
};