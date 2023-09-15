class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> t : tickets) {
            String src = t.get(0);
            String dst = t.get(1);
            graph.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }

        LinkedList<String> itinerary = new LinkedList<>();

        dfsHelper("JFK", graph, itinerary);

        return itinerary;
    }

    private void dfsHelper(String currStop, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> nextStops = graph.getOrDefault(currStop, new PriorityQueue<>());
        while (!nextStops.isEmpty()) {
            String nextStop = nextStops.poll();
            dfsHelper(nextStop, graph, itinerary);
        }
        itinerary.addFirst(currStop);
    }
}