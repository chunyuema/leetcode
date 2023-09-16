class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        // Build the graph based on edges given
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            graph.computeIfAbsent(n1, k -> new ArrayList<>()).add(new Pair<>(n2, succProb[i]));
            graph.computeIfAbsent(n2, k -> new ArrayList<>()).add(new Pair<>(n1, succProb[i]));
        }

        // probs tracks the maximum probability each node i in the graph
        double[] probs = new double[n];
        probs[start] = 1;

        // pq data structure to track the nodes to explore for dijkstra's algo
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>(
                (p1, p2) -> Double.compare(p2.getValue(), p1.getValue()));
        pq.offer(new Pair<>(start, 1.0));

        while (!pq.isEmpty()) {
            Pair<Integer, Double> curr = pq.poll();
            int currNode = curr.getKey();
            double probToCurrNode = curr.getValue();

            // early stopping if we reach the end, this is guaranteed to be the solution
            if (currNode == end)
                return probToCurrNode;

            for (Pair<Integer, Double> neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = neighbor.getKey();
                // Get the new probability to the next node, and update the prob to the next
                // node if it is smaller => Need to add the node back to the queue as well
                double probToNextNode = probToCurrNode * neighbor.getValue();
                if (probToNextNode > probs[nextNode]) {
                    probs[nextNode] = probToNextNode;
                    pq.offer(new Pair<>(nextNode, probToNextNode));
                }
            }
        }
        return probs[end];
    }
}