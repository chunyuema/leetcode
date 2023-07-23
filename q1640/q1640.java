class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            indexMap.put(pieces[i][0], i);
        }

        int j = 0;
        while (j < arr.length) {
            if (!indexMap.containsKey(arr[j])) {
                return false;
            }
            int[] piece = pieces[indexMap.get(arr[j])];
            for (int val : piece) {
                if (val != arr[j])
                    return false;
                j++;
            }
        }
        return true;
    }
}