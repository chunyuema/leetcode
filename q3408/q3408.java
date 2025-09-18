class Task {
    int taskId;
    int priority;

    public Task(int taskId, int priority) {
        this.taskId = taskId;
        this.priority = priority;
    }
}
class TaskManager {
    private TreeMap<Task, Integer> taskQueue;
    private Map<Integer, Integer> taskPriorityMap;

    public TaskManager(List<List<Integer>> tasks) {
        taskQueue = new TreeMap<Task, Integer>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority; // higher priority first
            }
            return b.taskId - a.taskId;
        });

        taskPriorityMap = new HashMap<>();

        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            taskQueue.put(new Task(taskId, priority), userId);
            taskPriorityMap.put(taskId, priority);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskQueue.put(new Task(taskId, priority), userId);
        taskPriorityMap.put(taskId, priority);
    }
    
    public void edit(int taskId, int newPriority) {
        int oldPriority = taskPriorityMap.get(taskId);
        Task oldTask = new Task(taskId, oldPriority);
        int userId = taskQueue.get(oldTask);

        taskQueue.remove(oldTask);
        add(userId, taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        int priority = taskPriorityMap.get(taskId);
        taskQueue.remove(new Task(taskId, priority));
        taskPriorityMap.remove(taskId);
    }
    
    public int execTop() {
        if (taskQueue.isEmpty()) return -1;
        Map.Entry<Task, Integer> topTaskEntry = taskQueue.firstEntry();
        rmv(topTaskEntry.getKey().taskId);
        return topTaskEntry.getValue();
    }
}