class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        vector<string> res;
        // only counting the first word is enough since we are finding intersection
        set<char> alpha(words[0].begin(), words[0].end());
        
        for (char a : alpha) {
            int min_length = INT_MAX;
            // minimum occurences ensure the occurence in the insection
            for (auto w : words) {
                int length = count(w.begin(), w.end(), a);
                min_length = min(min_length, length);
            }
            if (min_length > 0) {
                for (int i = 0; i < min_length; ++i) {
                    res.push_back(string(1, a));
                }
            }
        }
        return res;
    }
};