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
        Set<Integer> visited = new HashSet<>();

        // Use a min heap to track which one of the node should be explored the next
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] { 0, 0 });
        while (visited.size() < n) {

            // Get the information of the next node to be exxplore: the one with the minimum cost to extend to
            int nextNode = (minHeap.peek())[1];
            int costToNextNode = (minHeap.peek())[0];
            minHeap.poll();

            // Only explore a node if it has not been previously explored
            if (!visited.contains(nextNode)) {
                minCost += costToNextNode;
                visited.add(nextNode);
                for (int[] pairs : graph.getOrDefault(nextNode, new ArrayList<>())) {
                    int neighborNode = pairs[1];
                    int costToNeighbor = pairs[0];
                    minHeap.offer(new int[] { costToNeighbor, neighborNode });
                }
            }
        }
        return minCost;
    }
}