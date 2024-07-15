class Solution {
public:
    int minFlips(string target) {
        char cur = '0';
        int res = 0;
        
        for (int i = 0; i < target.length(); ++i) {
            cur = (res % 2) ? '1' : '0';
            if (cur != target[i]) {
                res++;
            }
        }
        
        return res;
    }
};