package q1514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            graph.computeIfAbsent(n1, k -> new ArrayList<>()).add(new Pair<>(n2, succProb[i]));
            graph.computeIfAbsent(n2, k -> new ArrayList<>()).add(new Pair<>(n1, succProb[i]));
        }

        double[] maxProdToNode = new double[n];
        maxProdToNode[start] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (Pair<Integer, Double> neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = neighbor.getKey();
                double probToNextNode = neighbor.getValue();
                double newProbToNextNode = maxProdToNode[currNode] * probToNextNode;
                if (newProbToNextNode > maxProdToNode[nextNode]) {
                    maxProdToNode[nextNode] = newProbToNextNode;
                    queue.add(nextNode);
                }
            }
        }
        return maxProdToNode[end];
    }
}