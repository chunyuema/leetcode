class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] courseSeq = new int[numCourses];
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            courseSeq[numTaken] = currCourse;
            numTaken++;
            for (int n : adjList.getOrDefault(currCourse, new ArrayList<>())) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        if (numTaken == numCourses) return courseSeq;
        return new int[0];
    }
}