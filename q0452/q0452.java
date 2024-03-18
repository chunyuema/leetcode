class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        int total = 1;
        int prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];
            if (currStart <= prevEnd)
                prevEnd = Math.min(prevEnd, currEnd);
            else {
                total += 1;
                prevEnd = currEnd;
            }
        }
        return total;
    }
}