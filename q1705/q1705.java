class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int lastDay = 0;
        for (int i = 0; i < days.length; i++) {
            lastDay = Math.max(lastDay, i + days[i]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int res = 0;
        for (int i = 0; i < lastDay; i++) {
            // harvest the apple of today
            if (i < apples.length && apples[i] != 0) {
                int expirationDate = i + days[i];
                int numberOfApples = apples[i];
                pq.offer(new int[] { expirationDate, numberOfApples });
            }

            // pop off the rotten apples / finished pile
            while (!pq.isEmpty()) {
                int[] pile = pq.peek();
                if (pile[0] <= i || pile[1] == 0) {
                    pq.poll();
                } else {
                    break;
                }
            }

            // eat an apple that expires the soonest
            if (!pq.isEmpty()) {
                int[] pile = pq.poll();
                pile[1] -= 1;
                pq.offer(pile);
                res++;
            }
        }
        return res;
    }
}