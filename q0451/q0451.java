class Solution {
    public String frequencySort(String s) {
        // Get the frequency of the characters
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Get the sorted char, count
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((
                p1, p2) -> p2.getValue() - p1.getValue());
        pq.addAll(charCountMap.entrySet());

        // Build the resultant string
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> p = pq.poll();
            res.append(p.getKey().toString().repeat(p.getValue()));
        }
        return res.toString();
    }
}