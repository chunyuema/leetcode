class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : arr)
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        List<Integer> counts = new ArrayList<>();
        counts.addAll(numCount.values());

        // Collections.sort(counts);

        counts.sort((a, b) -> Integer.compare(a, b));

        int res = counts.size();

        // Get the smallest count possible
        for (int count : counts) {
            // If the count is within the capcity of k, remove 1 element
            if (k >= count) {
                res -= 1;
                k -= count;
            }
            // If the count is not within the capacity of k, complete the operation
            else {
                break;
            }
        }
        return res;
    }
}