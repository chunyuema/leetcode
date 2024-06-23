class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Sort the heaters by distance
        Arrays.sort(heaters);
        
        // Initialize the min radius to be 0
        int minRadius = 0;
        
        // Iterate through all the house
        // For each house, find it closest heater
        for (int house : houses) {
            int closestHeater = findClosestHeater(house, heaters);
            int currRadius = Math.abs(closestHeater - house);
            minRadius = Math.max(minRadius, currRadius);
        }
        return minRadius;
    }
    
    private int findClosestHeater(int house, int[] heaters) {
        int l = 0; 
        int r = heaters.length - 1;
        
        // If the house is located below the range of heaters position
        if (house < heaters[l]) return heaters[l];
        if (house > heaters[r]) return heaters[r];
        
        // Look for the closest heater
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (heaters[m] == house) return heaters[m];
            else if (heaters[m] > house) r = m - 1;
            else l = m + 1;
        }
        
        // Pick the closest heater (heater[l], heater[r])
        if (Math.abs(heaters[l] - house) > 
            Math.abs(heaters[r] - house)) return heaters[r];
        return heaters[l];
    }
}