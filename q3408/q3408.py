class Task:
    def __init__(self, userId, taskId, priority):
        self.userId = userId
        self.taskId = taskId
        self.priority = priority
        self.isDone = False
    
    def __lt__(self, other): 
        if self.priority == other.priority:
            return self.taskId > other.taskId  # or some consistent tie-breaker
        return self.priority > other.priority

class TaskManager:

    def __init__(self, tasks: List[List[int]]):

        self.tasksPQ = []
        self.taskIdToTaskMap = dict()

        for t in tasks: 
            task = Task(t[0], t[1], t[2])
            self.taskIdToTaskMap[t[1]] = task 
            heappush(self.tasksPQ, task)
        
    def add(self, userId: int, taskId: int, priority: int) -> None:
        task = Task(userId, taskId, priority)
        self.taskIdToTaskMap[taskId] = task
        heappush(self.tasksPQ, task)

    def edit(self, taskId: int, newPriority: int) -> None:
        oldTask = self.taskIdToTaskMap[taskId]
        oldTask.isDone = True  # Mark old task as done

        # Create and insert new task with updated priority
        newTask = Task(oldTask.userId, taskId, newPriority)
        self.taskIdToTaskMap[taskId] = newTask
        heappush(self.tasksPQ, newTask)

    def rmv(self, taskId: int) -> None:
        task = self.taskIdToTaskMap[taskId]
        task.isDone = True

    def execTop(self) -> int:
        while self.tasksPQ:
            top = heappop(self.tasksPQ)
            if not top.isDone:
                top.isDone = True
                del self.taskIdToTaskMap[top.taskId]
                return top.userId
        return -1

# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()