class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrackHelper(res, new StringBuilder(), n, n);
        return res;
    }

    public void backtrackHelper(List<String> res, StringBuilder temp, int open, int close) {

        // base case: if open > close, or either one is less than zero, we violated the
        // rule, return immediately without further investigation
        if (open < 0 || close < 0 || open > close)
            return;

        // base case: if both are zero, we have constructed a valid parentheses string
        if (open == 0 && close == 0) {
            res.add(temp.toString());
            return;
        }

        // backtracking steps to add a ( to the current string
        temp.append("(");
        backtrackHelper(res, temp, open - 1, close);
        temp.deleteCharAt(temp.length() - 1);

        // backtracking steps to add a ) to the current string
        temp.append(")");
        backtrackHelper(res, temp, open, close - 1);
        temp.deleteCharAt(temp.length() - 1);
    }
}