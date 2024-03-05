class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] roomUsage = new int[n];

        // Track the rooms that are available
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            availableRooms.offer(i);

        // Track the scheduled meetings based on their ending time, and the room they
        // are assigned to use
        PriorityQueue<long[]> scheduledMeetings = new PriorityQueue<long[]>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        for (int[] meeting : meetings) {

            // Update the availability of rooms based on the next start time, because some
            // of the rooms might become available by then
            while (!scheduledMeetings.isEmpty() && scheduledMeetings.peek()[0] <= meeting[0]) {
                int room = (int) scheduledMeetings.poll()[1];
                availableRooms.offer(room);
            }

            // When there are rooms to host meetings, use the room with the lowest number
            // Add 1 to the room usage
            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                roomUsage[room]++;
                scheduledMeetings.offer(new long[] { meeting[1], room });
            }

            // When there are no rooms to host meetings, this current meeting will be
            // scheduled to room with the meeting that ends the earliest
            // Simply add 1 to the room usage, and update the meeting ending time
            else {
                long[] prevMeetingWithRoom = scheduledMeetings.poll();
                long endTime = prevMeetingWithRoom[0];
                int room = (int) prevMeetingWithRoom[1];
                roomUsage[room]++;
                scheduledMeetings.offer(new long[] { endTime + meeting[1] - meeting[0], room });
            }
        }

        int maxRoomUsage = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (roomUsage[i] > maxRoomUsage) {
                maxRoomUsage = roomUsage[i];
                res = i;
            }
        }
        return res;
    }
}