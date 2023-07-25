class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, new StringBuilder(), n, n);
        return res;
    }

    public void backtrack(List<String> res,
            StringBuilder temp,
            int openP, int closeP) {
        if (openP == 0 && closeP == 0) {
            res.add(temp.toString());
            return;
        }

        if (openP > 0) {
            temp.append("(");
            backtrack(res, temp, openP - 1, closeP);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (closeP > 0 && closeP > openP) {
            temp.append(")");
            backtrack(res, temp, openP, closeP - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}