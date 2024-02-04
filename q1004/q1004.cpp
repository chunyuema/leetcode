class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int zero = 0; // to keep track of the number of zeroes in our current window
        int max_len = INT_MIN, l = 0;
        for(int r = 0; r < nums.size(); r ++){
            if(nums[r] == 0)zero ++;
            // if the number of zeroes exceeds k, then shrink the window
            while(zero > k){
                if(nums[l] == 0){
                    zero --;
                }
                l ++;
            }
            max_len = max(max_len, r - l + 1);
        }
        return max_len;
    }
};