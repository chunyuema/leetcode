class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        int maxWidth = 0;
        for (int i = 1; i < points.length; i++) {
            int newWidth = points[i][0] - points[i - 1][0];
            maxWidth = Math.max(newWidth, maxWidth);
        }
        return maxWidth;
    }
}