public class Solution {
    
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Calculate the number of nodes for each tree
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Calculate the graph from edges
        final Map<Integer, List<Integer>> graph1 = getGraphFromEdges(edges1);
        final Map<Integer, List<Integer>> graph2 = getGraphFromEdges(edges2);
        
        // Find the longest path (diameter) in both graphs
        int diameter1 = getDiameter(n, graph1);
        int diameter2 = getDiameter(m, graph2);
        
        // The diameter of the merged graph will be the sum of the two diameters + 1
        int combinedDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    // Method to return a graph from a given set of edges
    private Map<Integer, List<Integer>> getGraphFromEdges(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int n1 = edge[0]; 
            int n2 = edge[1];
            graph.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            graph.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }
        return graph;
    }

    // Method to perform BFS and return the farthest node and its distance
    private int[] bfs(int start, int n, Map<Integer, List<Integer>> graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);  // -1 indicates unvisited
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;
        
        int farthestNode = start;
        int maxDistance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                int currNode = queue.poll();
                farthestNode = currNode;
                for (int neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
                    if (dist[neighbor] == -1) {  // If not visited
                        dist[neighbor] = 1;
                        queue.offer(neighbor);
                    }
                }
            }
            if (!queue.isEmpty()) maxDistance++;
        }
        
        return new int[] {farthestNode, maxDistance};
    }
    
    // Method to find the longest path (diameter) in the tree using BFS
    private int getDiameter(int n, Map<Integer, List<Integer>> graph) {
        // Step 1: Start BFS from an arbitrary node, say node 0 (or any node that's present in the graph)
        int[] result = bfs(0, n, graph);
        int farthestNodeFrom0 = result[0];
        
        // Step 2: Start BFS from the farthest node found to determine the diameter
        result = bfs(farthestNodeFrom0, n, graph);
        int farthestDistFromFarthest = result[1];

        return farthestDistFromFarthest;
    }
}

