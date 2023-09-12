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

        // maxProdToNode tracks the maximum probability each node i in the graph
        double[] maxProbToNode = new double[n];
        maxProbToNode[start] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (Pair<Integer, Double> neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = neighbor.getKey();
                double probToNextNode = neighbor.getValue();
                // Get the new probability to the next node, and update the prob to the next
                // node if it is smaller => Need to add the node back to the queue as well
                double newProbToNextNode = maxProbToNode[currNode] * probToNextNode;
                if (newProbToNextNode > maxProbToNode[nextNode]) {
                    maxProbToNode[nextNode] = newProbToNextNode;
                    queue.add(nextNode);
                }
            }
        }
        return maxProbToNode[end];
    }
}