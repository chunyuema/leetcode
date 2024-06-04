class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        // modified binary search
        int l = 0;
        int r = nums.size() - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                r = mid - 1; // go to the left
            } else if (mid < nums.size() - 1 && nums[mid] < nums[mid + 1]) {
                l = mid + 1; // go to the right
            } else {
                break;
            }
        }
        return mid;
    }
};