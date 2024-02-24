class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int p1 = meeting[0];
            int p2 = meeting[1];
            int time = meeting[2];
            graph.computeIfAbsent(p1, k -> new ArrayList<>());
            graph.get(p1).add(new int[] { p2, time });
            graph.computeIfAbsent(p2, k -> new ArrayList<>());
            graph.get(p2).add(new int[] { p1, time });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, firstPerson });
        for (int[] neighbor : graph.getOrDefault(0, new ArrayList<>())) {
            pq.offer(new int[] { neighbor[1], neighbor[0] });
        }

        Set<Integer> secretHolders = new HashSet<>();
        secretHolders.add(0);

        while (!pq.isEmpty()) {
            int currPerson = pq.peek()[1];
            int secretHoldingTime = pq.peek()[0];
            pq.poll();

            if (secretHolders.contains(currPerson))
                continue;
            secretHolders.add(currPerson);

            for (int[] neighbor : graph.getOrDefault(currPerson, new ArrayList<>())) {
                if (neighbor[1] >= secretHoldingTime) {
                    pq.offer(new int[] { neighbor[1], neighbor[0] });
                }
            }
        }

        return new ArrayList<>(secretHolders);
    }
}