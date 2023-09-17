class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereqCourse = pair[1];
            adjList.computeIfAbsent(prereqCourse, k -> new ArrayList<>()).add(course);
            indegree[course]++;
        }

        // Start with all the nodes with in degree = 0 (These courses have no
        // prerequiste)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int numTaken = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            numTaken++;
            for (int n : adjList.getOrDefault(currCourse, new ArrayList<>())) {
                // After taking this currCourse, all the courses which have the current course
                // as a prerequisite can have their in degree decreased by 1.
                indegree[n]--;

                // Add the course to the queue if the indegree becomes 0 (No more pre-requisite,
                // hence the course is ready to be taken)
                if (indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }

        return numTaken == numCourses;
    }
}