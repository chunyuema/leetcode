class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (int[] b1, int[] b2) -> (b2[1] - b1[1]));
        int i = 0;
        int res = 0;
        while (i < boxTypes.length && truckSize > 0) {
            res += Math.min(truckSize, boxTypes[i][0]) * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            i++;
        }
        return res;
    }
}