class Solution {
    public int maxChunksToSorted(int[] arr) {
        int currMax = arr[0];
        int maxChunks = 0;
        for (int i = 0; i < arr.length; i++) {
            // Expand the window and update the window condition
            currMax = Math.max(arr[i], currMax);
            
            // If window condition meets criteria, greedily assign chunks
            if (currMax == i) maxChunks++;
        }
        return maxChunks;
    }
}
