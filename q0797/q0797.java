class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        backtrackHelper(graph, res, temp);
        return res;
    }

    private void backtrackHelper(int[][] graph, List<List<Integer>> res, List<Integer> temp) {
        int currNode = temp.get(temp.size() - 1);
        if (currNode == graph.length - 1) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int neighbor : graph[currNode]) {
            temp.add(neighbor);
            backtrackHelper(graph, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}