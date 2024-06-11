class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxNum = arr1[0];
        for (int num : arr1) maxNum = Math.max(num, maxNum);
        
        int[] counts = new int[maxNum + 1]; 
        for (int num : arr1) counts[num]++;
        
        
        int[] res = new int[arr1.length];
        int i = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                res[i++] = num;
                counts[num]--;
            }
        }
        
        for (int num = 0; num <= maxNum; num++) {
            while (counts[num] > 0) {
                res[i++] = num;
                counts[num]--;
            }
        }
        
        return res;
    }
}
