class Solution {
    public long repairCars(int[] ranks, int cars) {
        long lo = 1;
        long hi = 1L * ranks[0] * cars * cars;

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long totalCarsRepairedInMid = totalCarsRepaired(mid, ranks);
            if (totalCarsRepairedInMid < cars) {
                // If mid is not sufficient time to repair cars, increase lo
                // to find more time to repair all cars
                lo = mid + 1;
            } else {
                // If mid is sufficient time to repair cars, decrease hi to see
                // if we can repair the cars in less time
                hi = mid;
            }
        }
        return lo;
    }

    /** 
    * Compute the total number of cars that all mechanics can repair 
    * totalTime: The total time available for all mechanics
    * ranks: The ranks of the car mechanics
    */
    private long totalCarsRepaired(long totalTime, int[] ranks) {
        long totalCars = 0;
        for (int rank : ranks) {
            totalCars += (long)(Math.sqrt(totalTime / rank));
        }
        return totalCars;
    } 
}
