class Solution {
    public int maxEvents(int[][] events) {
        int lastDay = 0;
        for (int[] event : events) {
            lastDay = Math.max(event[1], lastDay);
        }

        int currIdx = 0;
        int eventsAttended = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (e1, e2) -> e1[0] - e2[0]);
        for (int currDay = 1; currDay <= lastDay; currDay++) {
            // remove all the events that are already ended
            while (!pq.isEmpty() && pq.peek() < currDay)
                pq.poll();

            // add all the events that are starting on the current day
            while (currIdx < events.length && events[currIdx][0] == currDay) {
                pq.offer(events[currIdx][1]);
                currIdx++;
            }

            // get the event that will end the earliest, and greedily attend that
            if (!pq.isEmpty()) {
                pq.poll();
                eventsAttended++;
            }
        }

        return eventsAttended;
    }
}