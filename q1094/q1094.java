class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];

        // for each trip record how it changes the number of people getting on and off
        // at each stop
        for (int[] trip : trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }

        // go through the trips, simply make sure that at no time does the currLoad
        // exceeds the capacity
        int currLoad = 0;
        for (int numOfPeople : stops) {
            currLoad += numOfPeople;
            if (currLoad > capacity)
                return false;
        }
        return true;
    }
}