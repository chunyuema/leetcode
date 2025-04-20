class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> groupsBySizes = new HashMap<>();
        for (int ans : answers) {
            // Get the size of the group
            int size = ans + 1; 
            groupsBySizes.put(size, groupsBySizes.getOrDefault(size, 0) + 1);
        }

        int totalRabbits = 0;
        for (Map.Entry<Integer, Integer> entry : groupsBySizes.entrySet()) {
            int size = entry.getKey();
            int count = entry.getValue();
            // Calculate the number of full groups
            int numFullGroups = (count / size) + (count % size != 0 ? 1 : 0);
            totalRabbits += (size * numFullGroups);
        }
        return totalRabbits;
    }
}
