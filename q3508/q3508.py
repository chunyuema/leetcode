class Router:
    def __init__(self, memoryLimit: int):
        self.memoryLimit = memoryLimit
        self.msgQueue = deque()
        self.msgSet = set()
        self.destinationMap = defaultdict(deque)

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        newPacket = (source, destination, timestamp)
        if newPacket in self.msgSet:
            return False
        else:
            if len(self.msgSet) == self.memoryLimit:
                oldestPacket = self.msgQueue.popleft()
                self.msgSet.remove(oldestPacket)
                self.destinationMap[oldestPacket[1]].popleft()

            self.msgQueue.append(newPacket)
            self.msgSet.add(newPacket)
            self.destinationMap[destination].append(timestamp)
            return True

    def forwardPacket(self) -> List[int]:
        if not self.msgQueue:
            return []
        nextPacket = self.msgQueue.popleft()
        self.msgSet.remove(nextPacket)
        self.destinationMap[nextPacket[1]].popleft()
        return nextPacket

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        timestamps = self.destinationMap[destination]
        left = bisect_left(timestamps, startTime)
        right = bisect_right(timestamps, endTime)
        return right - left