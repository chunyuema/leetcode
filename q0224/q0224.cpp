class Solution {
public:
    int calculate(string s) {
        int cur = 0;
        int res = 0;
        int sign = 1;
        std::stack<int> stack;

        for (char c : s) {
            if (isdigit(c)) {
                cur = cur * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += sign * cur;
                sign = (c == '+') ? 1 : -1;
                cur = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * cur;
                res *= stack.top(); stack.pop();
                res += stack.top(); stack.pop();
                cur = 0;
            }
        }

        return res + sign * cur; 
    }
};