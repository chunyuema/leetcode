class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xDist = Math.abs(fx - sx);
        int yDist = Math.abs(fy - sy);
        if (xDist == 0 && yDist == 0 && t == 1)
            return false;
        return t >= Math.max(xDist, yDist);
    }
}