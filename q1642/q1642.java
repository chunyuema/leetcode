class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // all the heights diff climbed with ladders (sorted from small -> big)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {
            // first use ladder for everything, but track the heights we used ladder for
            int heightSkipped = heights[i] - heights[i - 1];
            if (heightSkipped > 0)
                pq.offer(heightSkipped);

            // climb previous recorded smallest height with bricks instead and use ladder
            // for the current climb to go farther
            // since the bricks were used on the smallest height from before, we can
            // greedily go as far as possible
            if (pq.size() > ladders)
                bricks -= pq.poll();
            if (bricks < 0)
                return i - 1;
        }
        return heights.length - 1;
    }
}