class Solution {
    public int findChampion(int n, int[][] edges) {
        // There should only be one node with indegree = 0
        int[] inDegrees = new int[n];
        for (int[] pair : edges) {
            inDegrees[pair[1]]++;
        }

        // Find the one and only one potential champion
        int champion = -1; 
        int potentialChampNum = 0; 
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                potentialChampNum++;
                champion = i;
            }
        } 

        // If there are more than 1 potential champion, return -1 since it is not unique
        if (potentialChampNum != 1) return -1;

        // As long as no other team is stronger, this team could be a champion
        return champion;
    }
}