class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            graph.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        int maxRank = 0;
        for (int n1 = 0; n1 < n; n1++) {
            for (int n2 = n1 + 1; n2 < n; n2++) {
                Set<Integer> n1Neighbors = graph.getOrDefault(n1, Collections.emptySet());
                Set<Integer> n2Neighbors = graph.getOrDefault(n2, Collections.emptySet());
                int currRank = n1Neighbors.size() + n2Neighbors.size();
                if (n1Neighbors.contains(n2))
                    currRank--;
                maxRank = Math.max(maxRank, currRank);
            }
        }
        return maxRank;
    }
}