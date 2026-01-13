class Solution:
    def countMentions(self, numberOfUsers: int, events: List[List[str]]) -> List[int]:
        # Process the OFFLINE status change first before MESSAGE if same time stamp
        # False < True in Python, hence sort by time stamp first, then by e[0] == "MESSAGE
        events.sort(key=lambda e: (int(e[1]), e[0] == "MESSAGE"))
        print(events)

        # The most recent time stamp after which the user will be awake
        wakeup_time = [0] * numberOfUsers
        mentions = [0] * numberOfUsers

        for activity, timestamp, message in events:
            curr = int(timestamp)
            if activity == "MESSAGE":
                # @ALL mentions everyone regardless of online / offline
                if message == "ALL": 
                    mentions = list(map(lambda x : x + 1, mentions))
                # @HERE mentions only those who are online
                elif message == "HERE": 
                    for user, time in enumerate(wakeup_time):
                        if time <= curr:
                            mentions[user] += 1
                # Need to manually loop through the mentioned list
                else: 
                    users_to_check = list(int(id[2:]) for id in message.split(" "))
                    for user in users_to_check:
                        mentions[user] += 1
            else:
                wakeup_time[int(message)] = curr + 60
        return mentions
