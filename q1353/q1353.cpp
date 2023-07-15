class Solution
{
public:
    int maxEvents(vector<vector<int>> &events)
    {
        int lastDay = 0;
        for (auto event : events)
            lastDay = max(lastDay, event[1]);

        sort(events.begin(), events.end());
        int currIdx = 0;
        int maxEventsAttended = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int currDay = 1; currDay <= lastDay; currDay++)
        {
            // remove the events that are already ended
            while (!pq.empty() && pq.top() < currDay)
                pq.pop();

            // add all the events that are starting on the current day
            while (currIdx < events.size() && events[currIdx][0] == currDay)
            {
                pq.push(events[currIdx][1]);
                currIdx++;
            }

            // greedily attend the event that will end the earliest
            if (!pq.empty())
            {
                pq.pop();
                maxEventsAttended++;
            }
        }

        return maxEventsAttended;
    }
};