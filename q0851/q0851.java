class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length; 

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] r : richer) {
            graph[r[1]].add(r[0]);
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            dfsHelper(res, i, quiet, graph);
        }
        return res;
    }

    // return the person that satisfy the needs of the curr person: the minimum loudness person who is at least richer than the current person 
    private int dfsHelper(int[] res, int currPerson, int[] quiet, ArrayList<Integer>[] graph) {

        // base case: if the answer for the current person has been determined, return that ans
        if (res[currPerson] != -1) {
            return res[currPerson];
        } 

        // recursive case: 
        // the person themselves is can be the answer if no other options are found, hence we will initialize it to be the potential answer
        int ans = currPerson;
        for (int neighbor : graph[currPerson]) {
            // find the minimum loudness yet richest person of the neighbor by calling on the candidate
            int candidate = dfsHelper(res, neighbor, quiet, graph);
            // if the candidate has a lower loudness, then update the answer
            if (quiet[candidate] < quiet[ans]) {
                ans = candidate;
            }
        }
        res[currPerson] = ans;
        return ans;
    }
}