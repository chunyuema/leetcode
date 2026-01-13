class Solution {
public:
    string reverseParentheses(string s) {
        stack<char> stack;
        for (char c : s) {
            if (c == ')') {
                string part;
                while (stack.top() != '(') {
                    part += stack.top();
                    stack.pop();
                }
                stack.pop(); // remove '('
                for (char ch : part) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }

        string result;
        while (!stack.empty()) {
            result += stack.top();
            stack.pop();
        }
        reverse(result.begin(), result.end());
        return result;
    }
};