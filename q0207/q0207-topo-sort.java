class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereqCourse = pair[1];
            adjList.computeIfAbsent(prereqCourse, k->new ArrayList<>()).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int numTaken = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            numTaken++;
            for (int n : adjList.getOrDefault(currCourse, new ArrayList<>())) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }

        return numTaken == numCourses;
    }
}