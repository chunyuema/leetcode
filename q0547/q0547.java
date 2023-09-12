class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] isVisited = new int[isConnected.length];
        int numOfProvince = 0;
        for (int i = 0; i < isConnected.length; i++) {
            // if the current city has not been explore, explore everything that forms an
            // province with it
            if (isVisited[i] != 1) {
                numOfProvince++;
                dfsHelper(isConnected, isVisited, i);
            }
        }
        return numOfProvince;
    }

    private void dfsHelper(int[][] isConnected, int[] isVisited, int i) {
        // mark the current city as visited
        isVisited[i] = 1;

        // loop through other cities to look for the ones that is connected to the
        // current city
        for (int j = 0; j < isConnected.length; j++) {
            // if j and i are connected, and if j has not been explored, recursively perform
            // DFS on j to connect all the villages into province
            if (isConnected[i][j] == 1 && isVisited[j] != 1) {
                dfsHelper(isConnected, isVisited, j);
            }
        }
        return;
    }
}