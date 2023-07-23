class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            // first use ladder for everything, but track the heights we used ladder for
            int heightSkipped = heights[i] - heights[i - 1];
            if (heightSkipped > 0)
                pq.offer(heightSkipped);

            // when ladder used up, see if we can cover with bricks from previous heights
            // skipped
            if (pq.size() > ladders)
                bricks -= pq.poll();
            if (bricks < 0)
                return i - 1;
        }
        return heights.length - 1;
    }
}