class Solution {
    public int minCostConnectPoints(int[][] points) {

        // Construct the graph (bidirectional in this case)
        int n = points.length;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                graph.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] { dist, j });
                graph.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] { dist, i });
            }
        }

        int minCost = 0;

        // mstNodes tracks everything that is in the minimum spanning tree
        Set<Integer> mstNodes = new HashSet<>();

        // Use a pq to track which one of the node should be explored the next
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            // take a node (with minimum cost to extend to) from the pq to examine
            int[] curr = pq.poll();
            int currNode = curr[1];
            int costToCurrNode = curr[0];

            // if the node is already in the mst, do not explore it again
            if (mstNodes.contains(currNode))
                continue;

            // add the cost to the minCost, and add the node to the mst
            minCost += costToCurrNode;
            mstNodes.add(currNode);
            // if we have collected all the nodes, short circuit this and return min cost
            if (mstNodes.size() == n)
                return minCost;

            for (int[] pairs : graph.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = pairs[1];
                int costToNextNode = pairs[0];
                pq.offer(new int[] { costToNextNode, nextNode });
            }
        }
        return minCost;
    }
}