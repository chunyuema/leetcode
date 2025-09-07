class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int i = 0;
        for (int num = 1; num <= n / 2; num++) {
            arr[i++] = num;
            arr[i++] = num * -1;
        }
        // Can be ignored since the array is prefilled with 0
        // if (i == n - 1) arr[i] = 0; 

        return arr;
    }
}
