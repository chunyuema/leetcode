class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] isChecked = new boolean[n];
        boolean[] isInvestigating = new boolean[n];

        for (int i = 0; i < n; i++) {
            checkCycle(i, graph, isChecked, isInvestigating);
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isInvestigating[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public boolean checkCycle(int currNode, int[][] graph, boolean[] isChecked, boolean[] isInvestigating) {

        // if currNode is already under investigation, there is a cycle
        if (isInvestigating[currNode])
            return true;

        // if currNode has been checked before, then there is not a loop
        if (isChecked[currNode])
            return false;

        // mark the currNode as visited
        isChecked[currNode] = true;

        // mark the currNode as under investigation
        isInvestigating[currNode] = true;

        for (int neighborNode : graph[currNode]) {
            // if any of the neighbor node leads to a cycle, return true
            // if return true, we skip the next step which marks the currNode as no longer
            // under investigation
            if (checkCycle(neighborNode, graph, isChecked, isInvestigating)) {
                return true;
            }
        }

        // remove the currNode from under investigation as we have checked it, it does
        // not lead to a cycle
        isInvestigating[currNode] = false;

        return false;
    }

}