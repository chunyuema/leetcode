class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Sort the houses and heaters by distance
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        // Lowest range of the radius = 0
        int l = 0;
        // Highest range of the radius = MAX
        int r = Integer.MAX_VALUE;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            // If the radius can be used, set r = m
            // Since we are looking for the min radius
            if (checkIfRadiusOk(houses, heaters, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    private boolean checkIfRadiusOk(int[] houses, int[] heaters, int radius) {
        int i = 0; 
        int j = 0;
        while (i < houses.length && j < heaters.length) {
            if (Math.abs(houses[i] - heaters[j]) <= radius) i++;
            else j++;
        }
        return i == houses.length;
    }
}