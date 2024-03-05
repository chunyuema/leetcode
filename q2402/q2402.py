class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        # Track the usage of the rooms
        roomUsage = [0 for _ in range(n)]

        # First priority queue for the rooms available
        availableRooms = [i for i in range(n)]

        # Second priority queue track the end time of the meeting, and their rooms
        scheduledMeeting = []

        for meeting in sorted(meetings): 
            # Update the availableRooms since the previous meetings might have ended
            while scheduledMeeting and scheduledMeeting[0][0] <= meeting[0]:
                room = heappop(scheduledMeeting)[1]
                heappush(availableRooms, room)

            # When there are new rooms to host meetings
            if len(availableRooms) != 0:
                room = heappop(availableRooms)
                heappush(scheduledMeeting, [meeting[1], room]) 
                roomUsage[room] += 1
                
            # When there are no rooms to host meetings
            else: 
                # Get the room that will end the earliest
                endtime, room = heappop(scheduledMeeting)
                # Track the room again with the updated end time
                heappush(scheduledMeeting, [endtime + meeting[1] - meeting[0], room]) 
                roomUsage[room] += 1
    
        maxRoomUsage = max(roomUsage) 
        return roomUsage.index(maxRoomUsage)