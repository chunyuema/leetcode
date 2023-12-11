class Solution {
    public int findSpecialInteger(int[] arr) {
        int i = 0; 
        int n = arr.length / 4;
        while (i < arr.length - n) {
            // check the window satisfies the condition
            if (arr[i] == arr[i + n]) return arr[i];
            // move the start to the next window starting
            i++;
        }
        return -1;
    }
}