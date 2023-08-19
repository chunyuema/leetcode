class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++)
                newEdges[i][j] = edges[i][j];
            newEdges[i][3] = i;
        }

        // Sort edges
        Arrays.sort(newEdges, Comparator.comparingInt(e -> e[2]));
        // Find MST through Union Find
        UnionFind uf = new UnionFind(n);
        int minCost = 0;
        for (int[] e : newEdges) {
            if (uf.union(e[0], e[1]))
                minCost += e[2];
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> nonCritical = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] currEdge = newEdges[i];

            // Ignore current edge and rebuild MST
            UnionFind ufIgnore = new UnionFind(n);
            int ignoreMinCost = 0;
            for (int j = 0; j < m; j++) {
                int[] e = newEdges[j];
                if (i != j && ufIgnore.union(e[0], e[1]))
                    ignoreMinCost += e[2];
            }

            // If MST cannot be built / min cost is higher => critical path
            if (ufIgnore.maxSize < n || ignoreMinCost > minCost) {
                critical.add(currEdge[3]);
            } else {
                // Force the current edge and rebuild MST
                UnionFind ufForce = new UnionFind(n);
                ufForce.union(currEdge[0], currEdge[1]);
                int forceMinCost = currEdge[2];
                for (int j = 0; j < m; j++) {
                    int[] e = newEdges[j];
                    if (i != j && ufForce.union(e[0], e[1]))
                        forceMinCost += e[2];
                }
                if (forceMinCost == minCost)
                    nonCritical.add(currEdge[3]);
            }
        }

        return new ArrayList(List.of(critical, nonCritical));
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int maxSize;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        maxSize = 1;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        // Finds the root of x
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        // Connects x and y
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            maxSize = Math.max(maxSize, size[rootX]);
            return true;
        }
        return false;
    }
}