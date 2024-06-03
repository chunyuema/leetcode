class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        vector<int> pairs;
        sort(potions.begin(), potions.end());
        
        for (int i = 0; i < spells.size(); ++i) {
            // implement binary search
            int l = 0;
            int r = potions.size() - 1;
            int position = potions.size();
            
            while (l <= r) {
                int mid = (r + l) / 2;
                if ((long long)spells[i] * potions[mid] >= success) {
                    r = mid - 1;
                    position = mid;
                } else {
                    l = mid + 1;
                }
            }
            
            pairs.push_back(potions.size() - position);
        }
        
        return pairs;
    }
};