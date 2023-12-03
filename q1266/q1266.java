class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for (int i = 1; i < points.length; i++) {
            minTime += getMinTimeBetweenTwoPoints(points[i], points[i - 1]);
        }
        return minTime;
    }

    private int getMinTimeBetweenTwoPoints(int[] p1, int[] p2) {
        int xDist = Math.abs(p1[0] - p2[0]);
        int yDist = Math.abs(p1[1] - p2[1]);
        return Math.max(xDist, yDist);
    }
}