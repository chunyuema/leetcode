class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1[0] != p2[0])
                return Integer.compare(p1[0], p2[0]);
            else
                return Integer.compare(p1[1], p2[1]);
        });

        for (int i = 0; i < mat.length; i++) {
            int soldierCount = 0;
            for (int num : mat[i])
                soldierCount += num;
            pq.offer(new int[] { soldierCount, i });
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = (pq.poll())[1];
        }
        return res;
    }
}