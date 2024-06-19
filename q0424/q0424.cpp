class Solution {
public:
    int characterReplacement(string s, int k) {
        int max_occur = 0;
        unordered_map<char, int> cnt;
        int l = 0, r = 0;
        int res = INT_MIN;
        
        while (r < s.size()) {
            cnt[s[r]]++;
            max_occur = 0;
            for (auto it = cnt.begin(); it != cnt.end(); ++it) {
                max_occur = max(max_occur, it->second);
            }

            if ((r - l + 1 - max_occur) <= k) {
                res = max(res, r - l + 1);
            }

            while ((r - l + 1 - max_occur) > k) {
                cnt[s[l]]--;
                l++;
                max_occur = 0;
                for (auto it = cnt.begin(); it != cnt.end(); ++it) {
                    max_occur = max(max_occur, it->second);
                }
            }

            r++;
        }

        if ((r - l + 1 - max_occur) <= k) {
            res = max(res, r - l);
        }

        return res; 
    }
};