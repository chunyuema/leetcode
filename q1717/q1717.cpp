class Solution {
public:
    int maximumGain(string s, int x, int y) {
        auto removeStrings = [](string s, string pair, int score) {
            stack<char> stack;
            int res = 0;
            for (char c : s) {
                if (!stack.empty() && stack.top() == pair[0] && c == pair[1]) {
                    stack.pop();
                    res += score;
                } else {
                    stack.push(c);
                }
            }
            string remaining;
            while (!stack.empty()) {
                remaining += stack.top();
                stack.pop();
            }
            reverse(remaining.begin(), remaining.end());
            return make_pair(res, remaining);
        };

        int res1, res2;
        if (x > y) {
            tie(res1, s) = removeStrings(s, "ab", x);
            tie(res2, s) = removeStrings(s, "ba", y);
        } else {
            tie(res1, s) = removeStrings(s, "ba", y);
            tie(res2, s) = removeStrings(s, "ab", x);
        }
        return res1 + res2; 
    }
};