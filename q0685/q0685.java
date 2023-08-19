class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegrees = new int[edges.length + 1];
        int nodeWithInDegreeTwo = -1;
        for (int[] e : edges) {
            inDegrees[e[1]]++;
            if (inDegrees[e[1]] == 2) {
                nodeWithInDegreeTwo = e[1];
                break;
            }
        }
        // If there is no node with indegreee = 2, then simply check the cycle
        // (identical to 684)
        if (nodeWithInDegreeTwo == -1)
            return checkCycle(edges, null);

        // If there are node with indegree = 2, loop backwards to identity which edge
        // can be removed
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] currEdge = edges[i];
            // if removing the current edge can remove the cycle in the graph, it can be
            // removed
            if (currEdge[1] == nodeWithInDegreeTwo && checkCycle(edges, currEdge) == null)
                return currEdge;
        }

        return null;
    }

    private int[] checkCycle(int[][] edges, int[] edgeSkipped) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] e : edges) {
            if (Arrays.equals(e, edgeSkipped))
                continue;
            if (!uf.union(e[0], e[1]))
                return e;
        }
        return null;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot)
            return false;
        else if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[xRoot] > rank[yRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
        return true;
    }
}