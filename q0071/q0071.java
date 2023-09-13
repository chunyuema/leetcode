class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        for (String token : tokens) {
            // We will pop a direct if we see '..'
            if (token.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
                // If not, we add only the meaningful ones (not '.' or '')
            } else {
                if (!token.equals(".") && !token.equals(""))
                    stack.push('/' + token);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        if (sb.length() == 0)
            return "/";
        return sb.toString();
    }
}