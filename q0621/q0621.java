class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> t2[1] - t1[1]);
        for (Map.Entry<Character, Integer> entry : taskCounts.entrySet()) {
            pq.add(new int[] { entry.getKey(), entry.getValue() });
        }

        // The number of idle slots created by the most frequent task
        int maxCount = pq.poll()[1];
        int idleSlots = n * (maxCount - 1);

        // Use other tasks to fill int the idle slot as much as possible
        // Prioritize tasks with higher count to avoid creating more idle slots
        while (!pq.isEmpty()) {
            int[] currTask = pq.poll();
            // Max number that a task can be used is maxCount - 1
            // Note that itself needs cool down period too
            // Total count of the task is counts.popleft()[1]
            // The number of slots that currTask can fill is the min of the two
            // Subtract that from the idleSlots
            idleSlots -= Math.min(maxCount - 1, currTask[1]);
        }

        return tasks.length + Math.max(0, idleSlots);
    }
}