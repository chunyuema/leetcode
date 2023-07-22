class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int r = 0;
        while (r < chars.length) {
            int currCount = 1;
            while (r + 1 < chars.length && chars[r + 1] == chars[r]) {
                r++;
                currCount++;
            }

            chars[l] = chars[r];
            l++;
            if (currCount > 1) {
                char[] currCountCharArr = Integer.toString(currCount).toCharArray();
                for (char c : currCountCharArr) {
                    chars[l] = c;
                    l++;
                }
            }
            r++;
        }
        return l;
    }
}