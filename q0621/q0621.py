class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        tasksWithCount = deque(Counter(tasks).most_common())

        # The number of idle slots created by the most frequent task
        maxCount = tasksWithCount.popleft()[1]
        idleSlots = (maxCount-1) * n
        
        # Use other tasks to fill int the idle slot as much as possible
        # Prioritize tasks with higher count to avoid creating more idle slots
        while tasksWithCount: 
            currTask = tasksWithCount.popleft()
            # Max number that a task can be used is maxCount - 1 (itself needs cool down period too) 
            # Total count of the task is counts.popleft()[1]
            # The number of slots that currTask can fill is the min of the two
            # Subtract that from the idleSlots
            idleSlots -= min(maxCount-1, currTask[1])
        
        return len(tasks) + max(0, idleSlots)
