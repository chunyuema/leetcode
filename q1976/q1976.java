class Solution {
    public int MOD = (int) (1e9 + 7);

    public int countPaths(int n, int[][] roads) {
        // Build the graph
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int[] r : roads) {
            int n1 = r[0], n2 = r[1];
            long dist = r[2];
            graph.computeIfAbsent(n1, k -> new ArrayList<>()).add(new Pair(n2, dist));
            graph.computeIfAbsent(n2, k -> new ArrayList<>()).add(new Pair(n1, dist));
        }

        // Let distToNode represent the minimum distance to the node i
        long[] distToNode = new long[n];
        Arrays.fill(distToNode, Long.MAX_VALUE);
        distToNode[0] = 0;

        // Let waysToNode represent the number of ways to reach node i (with the curent
        // min dist)
        int[] waysToNode = new int[n];
        waysToNode[0] = 1;

        // BFS Dikjstra Version with PQ instead of Q
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Long.compare(p1.dist, p2.dist));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair currPair = pq.poll();
            int currNode = currPair.node;
            long distToCurrNode = currPair.dist;

            for (Pair nextPair : graph.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = nextPair.node;
                long distToNextNode = nextPair.dist + distToCurrNode;

                // If a smaller distance is found:
                // 1. update the dist to node
                // 2. update # ways to node as the same as # of ways to currend node
                if (distToNextNode < distToNode[nextNode]) {
                    waysToNode[nextNode] = waysToNode[currNode];
                    distToNode[nextNode] = distToNextNode;
                    // Add the node to the PQ for further investigation
                    pq.add(new Pair(nextNode, distToNextNode));
                }
                // If the same distance is found:
                // Updat the number of ways is sufficient
                else if (distToNextNode == distToNode[nextNode]) {
                    waysToNode[nextNode] = (waysToNode[nextNode] + waysToNode[currNode]) % MOD;
                }
            }
        }
        return waysToNode[n - 1] % MOD;
    }
}

class Pair {
    public int node;
    public long dist;

    Pair(int node, long d) {
        this.node = node;
        this.dist = d;
    }
}