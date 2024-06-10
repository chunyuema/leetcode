class Solution {
public:
    string intToRoman(int num) {
        // a modified list to handle corner cases of 4, 9, 40, 90 ....
        vector<pair<string, int>> symList = {
            {"I", 1}, {"IV", 4}, {"V", 5}, {"IX", 9},
            {"X", 10}, {"XL", 40}, {"L", 50}, {"XC", 90},
            {"C", 100}, {"CD", 400}, {"D", 500}, {"CM", 900}, {"M", 1000}
        };
        
        // reverse the list so that we start converting from the largest rightmost digit
        reverse(symList.begin(), symList.end());
        
        string res = "";
        for (const auto& [sym, val] : symList) {
            int cnt = num / val;
            // for adding the characters based on the value digit
            for (int i = 0; i < cnt; ++i) {
                res += sym;
            }
            num %= val;
        }
        
        return res;
    }
};