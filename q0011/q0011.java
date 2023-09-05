class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length-1;
        while (l < r) {
            int leftBar = height[l];
            int rightBar = height[r];
            res = Math.max(res, Math.min(leftBar, rightBar) * (r-l));
            if (leftBar < rightBar) l++;
            else r--;
        }
        return res;
    }
}