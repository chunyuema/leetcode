class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int l = 0;
        int r = 0;
        int m = 0;
        int res = 0;
        int odd = 0;
        int n = nums.size();

        // start the three pointer sliding window technique
        while (r < n) {
            if (nums[r] % 2 == 1) {
                odd++;
            }
            while (odd > k) {
                if (nums[l] % 2 == 1) {
                    odd--;
                }
                l++;
                m = l;
            }
            if (odd == k) {
                while (nums[m] % 2 != 1) {
                    m++;
                }
                res += (m - l) + 1;
            }
            r++;
        }
        return res;
    }
};