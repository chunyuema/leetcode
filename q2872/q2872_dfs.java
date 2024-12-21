class Solution {
    private int maxComponentCount = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            graph[src].add(dst);
            graph[dst].add(src);
        }

        dfsHelper(0, -1, graph, values, k);
        
        return maxComponentCount;
    }

    // dfsHelper returns the sum of the subtree with a given node
    private int dfsHelper(int currNode, int parentNode, List<Integer>[] graph, int[] nodeVals, int k) {
        int currSum = nodeVals[currNode] % k; 
        for (int neighbor : graph[currNode]) {
            if (neighbor != parentNode) {
                currSum += dfsHelper(neighbor, currNode, graph, nodeVals, k);
                currSum %= k;
            }
        }
        // Whenever a currSum is zero, we have found a subtree with combined sum divisible by k
        // Greedily remove the subtree into one of the valid components, and increment the count by 1
        if (currSum == 0) maxComponentCount++;
        return currSum;
    }
}
