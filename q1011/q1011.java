class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // find the range
        int l = 0;
        int r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        // binary search
        while (l <= r) {
            int m = l + (r - l) / 2;

            // check if the mid value satisfy certain condition, then update the left and
            // right boundary
            int requiredDays = countDays(weights, m);

            // can finish within given days => reduce capacityload to see if smaller load is
            // possible
            if (requiredDays <= days)
                r = m - 1;

            // cannot finish within given time => increase capacity to satisfy condition
            else
                l = m + 1;
        }

        return l;
    }

    private int countDays(int[] weights, int capacity) {
        int totalDays = 1;
        int leftCapacity = capacity;
        int i = 0;
        while (i < weights.length) {
            int weight = weights[i];
            if (weight > leftCapacity) {
                totalDays += 1;
                leftCapacity = capacity;
            }
            leftCapacity -= weight;
            i++;
        }
        return totalDays;
    }
}