class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allVisitedState = (1 << n) - 1;
        int[][] states = new int[n][(1 << n)];

        Deque<int[]> queue = new ArrayDeque<>();
        // all the nodes can be used as the start node
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] { i, 1 << i, 1 });
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0];
            int currVisitedState = curr[1];
            int currLen = curr[2];

            // if the currVisitedState has all the nodes visited, then we have found the
            // shortest path
            if (currVisitedState == allVisitedState)
                return currLen - 1;

            for (int nextNode : graph[currNode]) {
                // get the nextVisitedState, and we only want to go there if the (nextNode,
                // nextVisitedState) has not been explored
                // this is because if it has been explored before, there is no point going there
                // again as we won't make more progress
                int nextVisitedState = currVisitedState | (1 << nextNode);
                if (states[nextNode][nextVisitedState] == 1)
                    continue;

                // if the new state has not been explored, mark it as explored, and push it on
                // to the queue for exploration
                states[nextNode][nextVisitedState] = 1;
                queue.offer(new int[] { nextNode, nextVisitedState, currLen + 1 });
            }
        }
        return -1;
    }
}