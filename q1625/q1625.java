class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.add(s);
        String minStr = s;

        while (!stack.isEmpty()) {
            String currStr = stack.pop();
            if (visited.contains(currStr)) continue; 
            visited.add(currStr);
            if (currStr.compareTo(minStr) < 0) minStr = currStr;

            String added = add(currStr, a);
            stack.add(added);

            String rotated = rotate(currStr, b);
            stack.add(rotated);
        }

        return minStr;
    }

    private String add(String s, int a) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        for (int i = 1; i < s.length(); i += 2) {
            arr[i] = (arr[i] + a) % 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num);
        return sb.toString();
    }

    private String rotate(String s, int b) {
        String p1 = s.substring(0, b);
        String p2 = s.substring(b, s.length());
        return p2 + p1;
    }
}
