class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        if (arr[0] > x) {
            return vector<int>(arr.begin(), arr.begin() + k);
        }
        if (arr[arr.size() - 1] < x) {
            return vector<int>(arr.end() - k, arr.end());
        }

        vector<int> res;
        int pos = 0;
        
        for (int i = 0; i < arr.size(); ++i) {
            if (i == 0) {
                if (x < arr[i]) {
                    pos = -1;
                    break;
                }
            } else {
                if (arr[i] >= x && arr[i - 1] <= x) {
                    pos = i - 1;
                }
            }
        }

        int l = pos;
        int r = pos + 1;
        
        while ((l >= 0 || r < arr.size()) && k > 0) {
            if (l < 0) {
                res.push_back(arr[r]);
                ++r;
            } else if (r >= arr.size()) {
                res.push_back(arr[l]);
                --l;
            } else if (abs(x - arr[l]) <= abs(x - arr[r])) {
                res.push_back(arr[l]);
                --l;
            } else {
                res.push_back(arr[r]);
                ++r;
            }
            --k;
        }
        
        sort(res.begin(), res.end());
        return res;   
    }
};