package q2462;

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>();

        for (int i = 0; i < candidates; i++) {
            p1.add(costs[i]);
        }

        for (int j = Math.max(candidates, costs.length - candidates); j < costs.length; j++) {
            p2.add(costs[j]);
        }

        long res = 0;
        int nextP1 = candidates;
        int nextP2 = costs.length - candidates - 1;

        while (k > 0) {
            int c1 = !p1.isEmpty() ? p1.peek() : Integer.MAX_VALUE;
            int c2 = !p2.isEmpty() ? p2.peek() : Integer.MAX_VALUE;
            if (c1 <= c2) {
                res += c1;
                p1.poll();
                if (nextP1 <= nextP2) {
                    p1.add(costs[nextP1]);
                    nextP1++;
                }
            } else {
                res += c2;
                p2.poll();
                if (nextP1 <= nextP2) {
                    p2.add(costs[nextP2]);
                    nextP2--;
                }
            }
            k--;
        }
        return res;
    }
}